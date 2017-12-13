/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.http.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 非阻塞Chargen服务器。
 *
 * 当不同操作有不同优先级的时候，可以在一个高优先级的线程中接受新连接，
 * 在一个低优先级的线程中对现有的连接提供服务，而线程和连接之间不再需要1:1的比例，大大提升服务器可扩展性。
 *
 * 多线程允许服务器利用多个CPU，接受线程与处理线程分开也是一个好的想法：
 * 接受连接的线程可以将接受的链接放在队列中，由池中的线程进行处理，
 * select()可以确保如果连接没有准备好接收数据，就不会在这些连接上浪费时间。
 *
 * @author shinnlove.jinsheng
 * @version $Id: ChargenServer.java, v 0.1 2017-12-13 下午1:22 shinnlove.jinsheng Exp $$
 */
public class ChargenServer {

    private static int DEFAULT_PORT = 19;

    public static void main(String[] args) {

        int port;
        try {
            port = Integer.parseInt(args[0]);
        } catch (RuntimeException e) {
            port = DEFAULT_PORT;
        }
        System.out.println("Listening for connections on port" + port);

        byte[] rotation = new byte[95 * 2];
        for (byte i = ' '; i < '~'; i++) {
            rotation[i - ' '] = i;
            rotation[i + 95 - ' '] = i;
        }

        // 开启服务端通道
        ServerSocketChannel serverChannel;
        Selector selector;
        try {
            serverChannel = ServerSocketChannel.open();
            ServerSocket ss = serverChannel.socket();
            InetSocketAddress address = new InetSocketAddress(port);
            ss.bind(address);
            serverChannel.configureBlocking(false);
            selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // 服务器无限循环处理客户端
        while (true) {
            try {
                selector.select(); // 直接返回ready通道数量，不阻塞
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 处理可能存在的ready通道
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                // 取出一个ready的通道键并从集合中移除防止重复处理
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    if (key.isAcceptable()) {
                        // 这个通道是服务端接收到了一个新客户端请求（server.accept产生一个客户端套接字）
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        System.out.println("Accept connection from " + client);
                        client.configureBlocking(false);

                        // 为客户端通道注册写的选择轮询器
                        SelectionKey key2 = client.register(selector, SelectionKey.OP_WRITE);

                        // 为客户端注册新的接收缓冲区
                        ByteBuffer buffer = ByteBuffer.allocate(74);
                        buffer.put(rotation, 0, 72);
                        buffer.put((byte) '\r');
                        buffer.put((byte) '\n');
                        buffer.flip();
                        key2.attach(buffer); // 特别注意：这里attach的，等下可以通过attachment得到这个缓冲区
                    } else if (key.isReadable()) {
                        // 这个通道是某个客户端已经准备好了数据等待服务器读入

                        // 打开客户端通道并且获取关联的缓冲区
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer outputBuffer = (ByteBuffer) key.attachment();

                        // 从客户端通道中读取缓冲区数据
                        client.read(outputBuffer);

                    } else if (key.isWritable()) {
                        // 这个通道对应的客户端已经可以让服务器写入数据了
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer) key.attachment();

                        // 如果缓冲区已经满了
                        if (!buffer.hasRemaining()) {
                            // 用下一行重新填充缓冲区
                            buffer.rewind();

                            // 得到上一行的首字符
                            int first = buffer.get();

                            // 准备改变缓冲区中数据
                            buffer.rewind();

                            // 寻找rotation中新的首字符位置
                            int position = first - ' ' + 1;

                            // 重要：将数据从rotation复制到缓冲区
                            buffer.put(rotation, position, 72);

                            // 在缓冲区末尾存储一个行分隔符
                            buffer.put((byte) '\r');
                            buffer.put((byte) '\n');

                            // 回转缓冲区，准备缓冲区进行写入
                            buffer.flip();
                        }

                        // 重要：向通道中写入这个缓冲区的数据
                        client.write(buffer);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException cex) {
                        cex.printStackTrace();
                    }
                }

            } // while iterator<SelectionKey>hasNext

        } // end while selector.select()

    }

}