/**
 * 公共类说明：
 * MLoading需要loading.gif图和Loading的css支持；
 * ART需要artDialog的css/js支持;
 * XHR中jqXHR增加了request的缓存，可以针对多个jsXHR数组进行提交、阻塞、终止。
 *
 * 依赖jQuery部分：（若使用jQuery扩展需要对jQuery.extension进行init）
 * XHR中的jqAjax:require(jQuery)；
 * Plugin中的剪贴板:require(jQuery)；
 *
 * @author chensheng.zcs
 * @version $Id: utils-common.js, v 0.2 2016年9月29日 下午4:58:53 chensheng.zcs Exp $
 */
var utils = {
    // 公共安全类
    Security: {},
    // 浏览器类
    Browser: {
        /** 浏览器请求头 */
        userAgent: "unknown",
        // set cookie
        setcookie: function (cookieName, cookieValue, seconds, path, domain, secure) {
            var expires = new Date();
            expires.setTime(expires.getTime() + seconds);
            document.cookie = escape(cookieName) + '=' + escape(cookieValue) + (expires ? '; expires=' + expires.toGMTString() : '') + (path ? '; path=' + path : '/') + (domain ? '; domain=' + domain : '') + (secure ? '; secure' : '');
        },
        // get cookie
        getcookie: function (name) {
            var cookies = document.cookie.split('; ');
            var len = cookies.length;
            for (var i = 0; i < len; i++) {
                var cookie = cookies[i].split('=');
                if (cookie[0] == name) {
                    return unescape(cookie[1]);
                }
            }
            return '';
        },
        /**
         * 得到Alipay的Cookie，用作Ctoken。
         *
         * @param key
         * @returns {string}
         */
        getAlipayCookie: function (key) {
            var m = new RegExp('\\b' + key + '\\=([^;]+)').exec(document.cookie);
            return m ? encodeURIComponent(m[1]) : '';
        },
        /**
         * 直接得到Alipay页面的CSRFtoken
         */
        getCtoken: function () {
            this.getAlipayCookie("ctoken");
        }
    },
    // 网络环境类
    NET: {
        /** 默认网络类型 */
        NETTYPE: 0,
        /** 网络无法连接 */
        NETTYPE_FAIL: -1,
        /** 网络是WIFI */
        NETTYPE_WIFI: 1,
        /** 网络是E（2G） */
        NETTYPE_EDGE: 2,
        /** 网络是3G */
        NETTYPE_3G: 3,
        /** 网络默认 */
        NETTYPE_DEFAULT: 0
    },
    // GEO地理位置类
    GPS: {
        // 获取当前位置
        getLocation: function () {
            /** 地理位置信息，-1代表未获取到 */
            var location = {
                errcode: -1,
                errmsg: "system error",
                longitude: -1,
                latitude: -1
            };
            if (navigator.geolocation) {
                // 浏览器允许获取地理位置的话
                navigator.geolocation.getCurrentPosition(function (position) {
                    if (position) {
                        window.longitude = location.longitude = position.coords.longitude; // 获取经度
                        window.latitude = location.latitude = position.coords.latitude; // 获取纬度
                        location.errcode = 0;
                        location.errmsg = "ok";
                    }
                    return location; // 返回地理位置信息
                }, function (error) {
                    if (error.code == "1") {
                        location.errcode = 1;
                        location.errmsg = "用户拒绝访问地理位置权限，请允许APP或浏览器获取地理位置。";
                    } else if (error.code == "2") {
                        location.errcode = 2;
                        location.errmsg = "无法确定设备的位置，一个或多个的用于定位采集程序报告了一个内部错误。";
                    } else if (error.code == "3") {
                        location.errcode = 2;
                        location.errmsg = "获取地理位置超时。";
                    }
                    return location; // 其他未知原因
                });
            }
            return location;
        }
    },
    // 路由地址类
    URI: {
        /**
         * 解析url传参函数。
         * @param str 要解析的url传参
         * @param key 如果需要找寻某个key值，则返回某个key值，没找到返回null；如果不需要找寻则返回解析后的传参数组
         */
        parseStr: function (str, key) {
            var params = str.split('&'); // 字符串以&分割name=shinnlove,pwd=abcd
            var query = {}; // 解析后的URL传参键值对
            var q = []; // 临时解析用的字符串数组，q[0]是name;q[1]是value
            var name = ''; // 临时存放urldecode后的key键名

            for (i = 0; i < params.length; i++) {
                q = params[i].split('='); // name=shinnlove再通过等号分割
                name = decodeURIComponent(q[0]); // decodeURIComponent，如果urlencode函数编码过，则可以转成正常的编码
                if (!name) {
                    continue; // 空字符串处理下一个
                }
                if (name.substr(-2) == '[]') {
                    // substr()形参如果是负数，-1代表最后一个字符到末尾即最后一个字符；-2代表倒数第二个字符到末尾即最后两个字符
                    // 如果形参是个空数组
                    if (!query[name]) {
                        query[name] = [];
                    }
                    query[name].push(q[1]);
                } else {
                    query[name] = q[1]; // 存入解析对象中
                }
            }

            // 如果形参传入key则寻找key
            if (key) {
                if (query[key]) {
                    return query[key]; // 如果对象中该key索引存在则返回
                } else {
                    return null; // 没找到key直接返回null
                }
            } else {
                return query; // 单纯解析URL则直接返回
            }
        },
        /**
         * 查询url参数函数。
         * @param key 可能要找寻的url的key值
         */
        getQuery: function (key) {
            var search = window.location.search; // window.location.search返回连同?后边的参数
            if (search.indexOf('?') != -1) {
                // 如果search字符串中带上了url传参
                var str = search.substr(1); // 截取?后边到末尾的字符串
                return utils.URI.parseStr(str, key); // 进行解析
            }
        },
        /**
         * 通过key值解析当前URL上的参数值
         * @param key
         * @returns {*}
         */
        getUrlParam: function (key) {
            var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r) return decodeURIComponent(r[2]);
            return "";
        },
        getUrlHash: function (key) {
            var reg = new RegExp("(#|&)" + key + "=([^&]*)(&|$)", "i");
            var r = location.hash.match(reg);
            if (r) return decodeURIComponent(r[2]);
            return "";
        },
        /**
         * 将文本转成超链接（html格式）
         * @param str
         * @returns {*}
         */
        formatTextWithUrl: function (str) {
            var Expression = '((https://)|(http://)|(www\\.)){1}[A-Za-z0-9-_:\/]+\\.[A-Za-z0-9-_:#%&\?\/.=]+';
            var objExp = new RegExp(Expression, "g");
            var hasUrl = objExp.test(str);
            if (hasUrl) {
                var r = str.match(objExp);
                var newStr = str;
                for (var i = 0; i < r.length; i++) {
                    if (r[i].indexOf("webim/face") < 0) {
                        newStr = newStr.replace(r[i], '<a href="' + ((r[i].indexOf("https://") < 0 && r[i].indexOf("http://") < 0) ? "http://" + r[i] : r[i]) + '">' + r[i] + '</a>');
                    }
                }
                return newStr;
            } else {
                return str;
            }
        }
    },
    // 校验类
    Validation: {
        /**
         * 判断一个变量是否是浮点数
         * @param valueToBeCheck
         * @returns {boolean}
         */
        isFloatNum: function (valueToBeCheck) {
            var reg = new RegExp("^(-?\\d+)(\\.\\d+)?$"); // 浮点数正则
            if (reg.test(valueToBeCheck)) return true;
            return false;
        },
        /**
         * 正则判断一个数是否正浮点数
         * @param pf
         * @returns {boolean}
         */
        isPositiveFloatNum: function (pf) {
            var reg = /^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$/;
            return reg.test(pf);
        },
        /**
         * 正则判断一个数是否是负浮点数
         * @param nf
         * @returns {boolean}
         */
        isNegativeFloatNum: function (nf) {
            var reg = /^-([1-9]\d*\.\d*|0\.\d*[1-9]\d*)$/;
            return reg.test(nf);
        },
        /**
         * 正则表达式判断一个数是否是整数
         * @param i
         * @returns {boolean}
         */
        isIntegerNum: function (i) {
            var reg = /^-?[1-9]\d*$/;
            return reg.test(i);
        },
        /**
         * 正则判断一个数是否是正整数
         * @param p
         * @returns {boolean}
         */
        isPositiveIntegerNum: function (p) {
            var re = /^[0-9]*[0-9][0-9]*$/; // 正整数正则
            return re.test(p);
        },
        /**
         * 正则判断一个数是否是负整数
         * @param n
         * @returns {boolean}
         */
        isNegativeIntegerNum: function (n) {
            var reg = /^-[1-9]\d*$/; // 负整数正则
            return reg.test(n)
        },
        isHrefURL: function (link) {
            var reg = /^(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&amp;:/~\+#]*[\w\-\@?^=%&amp;/~\+#])?/; // 匹配网址的正则表达式
            if (link.match(reg))  return true;
            return false;
        },
        /**
         * 判断一个字符串是不是Email
         * @param str 要判断的字符串
         */
        isEmail: function (mail) {
            var reg = new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/); // 匹配E-mail的正则
            return (reg.test(mail));
        },
        /**
         * 正则判断是否身份证,可以进行严格校验
         * @param num
         * @param strictValidation 强校验标记
         * @returns {boolean}
         */
        isIDCardNumber: function (num, strictValidation) {
            if (strictValidation) {
                // 严格校验
                if (isNaN(num)) return false;
                var len = num.length, reg;
                if (len == 15) {
                    // 15位身份证校验
                    reg = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{2})$/);
                } else if (len == 18) {
                    // 18位身份证校验
                    reg = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d)$/);
                }
                var flag = reg.test(num);
                // 日期校验略过
                return flag;
            } else {
                // 宽松校验
                var reg = /\d{15}|\d{18}/;
                return reg.test(num);
            }
        },
        /**
         * 判断是否手机号,强区号校验,
         * 日后可以根据三大供应商提供的区号段扩展。
         * @param cellphone
         * @returns {boolean}
         */
        isCellphoneNumber: function (cellphone) {
            var reg = /^1((3[0123456789])|(4[0123456789])|(5[0123456789])|(7[0123456789])|(8[0123456789]))(\d{8})/;
            return reg.test(cellphone);
        },
        /**
         * 判断是否国内固定电话
         * @param telNum
         * @returns {boolean}
         */
        isDomesticTel: function (telNum) {
            var reg = /\d{3}-\d{8}|\d{4}-\d{7}/;
            return reg.test(telNum);
        },
        /**
         * 判断一个地址是否是IP地址
         * @param ip
         * @returns {boolean}
         */
        isIPAddress: function (ip) {
            var reg = /\d+\.\d+\.\d+\.\d+/;
            return reg.test(ip);
        },
        /**
         * 判断一个文件是否图片格式
         * @param file 传入从html中获取的选中文件
         * @returns {boolean}
         */
        isImageFormat: function (file) {
            var imageRule = /\.jpg$|\.jpeg$|\.bmp$|\.png$|\.gif$/i;
            if (file) {
                return imageRule.test(file.name);
            }
            return false;
        },
    },
    // 字符串处理类
    String: {
        /** 全局charset，当前js库中文编码方式，要与html页面保持一致 */
        charset: 'utf-8',
        /**
         * 设置全局charset变量，处理字符串
         * @param charset
         */
        setGlobalCharset: function (charset) {
            this.charset = charset;
        },
        /**
         * 检查字符串是否以给定的内容开头
         * @param target
         * @returns {boolean}
         */
        strStartWith: function (target) {
            var reg = new RegExp("^" + target);
            return reg.test(this);
        },
        /**
         * 检查字符串是否以给定的内容结束
         * @param target
         * @returns {boolean}
         */
        strEndWith: function (target) {
            var reg = new RegExp(target + "$");
            return reg.test(this);
        },
        /**
         * 判断字符串中是否有中文
         * @param str 要检测的字符串
         * @returns {boolean}
         */
        hasChineseChar: function (str) {
            var flag = false;
            for (var i = 0; i < str.length; i++) {
                if (str.charCodeAt(i) >= 10000) {
                    flag = true;
                    break;
                }
            }
            return flag;
        },
        /**
         * 统计字符串长度函数（不含中文）。
         * 小常识：/msie/为IE独有的userAgent，因此/msie/.test(navigator.userAgent.toLowerCase())就是判断是否为IE浏览器，true|false。
         * 在IE浏览器中检测到字符串有\n换行，则替换\n为_，占1个字符位。
         * @param str 要统计长度的字符串
         * @return 返回字符串的length。
         */
        strlen: function (str) {
            return (/msie/.test(navigator.userAgent.toLowerCase()) && str.indexOf('\n') !== -1) ? str.replace(/\r?\n/g, '_').length : str.length;
        },
        get_strlen: function (str) {
            var i, len, code;
            if (str == null || str == "") return 0;
            len = str.length;
            for (i = 0; i < str.length; i++) {
                code = str.charCodeAt(i);
                if (code > 255) len++;
            }
            return len;
        },
        /**
         * 统计含有中文字符串长度。
         * 实现思路：charCodeAt()返回指定字符的unicode编码，依次来判断是英文字符还是中文字符。
         * 英文字符或数字长度占1，charCodeAt()函数返回在[0,255]区间的数字。
         * 第0～32号及第127号(共34个)是控制字符或通讯专用字符，如控制符：LF（换行）、CR（回车）、FF（换页）、DEL（删除）、BEL（振铃）等
         * 第33～126号(共94个)是字符，其中第48～57号为0～9十个阿拉伯数字；65～90号为26个大写英文字母，97～122号为26个小写英文字母，其余为一些标点符号、运算符号等。
         * 127~255之间有很多法文、西欧的字符。
         * 情形：str.charCodeAt(i) < 0 || str.charCodeAt(i) > 255表示非单字节英文字母。
         * 一旦非英文字符，以中文汉字编码方式来判断长度：
         * i) 如果当前汉字编码方式为utf-8则占据3个长度（依据本js的charset设置，与html页面保持一致）；
         * ii)不是utf-8（如GBK或GB2312编码）则占据2个长度。
         * @param str 要统计长度的含有中文的字符串
         */
        mb_strlen: function (str) {
            var len = 0;
            for (var i = 0; i < str.length; i++) {
                len += str.charCodeAt(i) < 0 || str.charCodeAt(i) > 255 ? (this.charset.toLowerCase() === 'utf-8' ? 3 : 2) : 1;
            }
            return len;
        },
        /**
         * 获取字符串的二进制流长度
         * @param str
         * @returns {*}
         */
        byte_strlen: function (str) {
            if (!str) {
                return 0;
            }
            var l = str.length;
            var n = l;
            for (var i = 0; i < l; i++) {
                if (str.charCodeAt(i) < 0 || str.charCodeAt(i) > 255) {
                    n++;
                }
            }
            return n;
        },
        /**
         * 当显示的中文字符串过长的裁剪显示函数。
         * 英文西欧字符长度1；utf-8中文长度3；gbk和gb2312中文长度2。
         * @param str 要截取的带中文字符串
         * @param maxlen 最大允许显示长度
         * @param dot 截取后多余部分显示代替符号
         */
        mb_cutstr: function (str, maxlen, dot) {
            var len = 0; // 当前统计到第几个字符
            var ret = ''; // 截取后的字符串
            var dot = !dot && dot !== '' ? '...' : dot; // 如果dot未定义默认...显示超长部分
            maxlen = maxlen - dot.length; // 最大允许显示长度要减去dot的长度
            for (var i = 0; i < str.length; i++) {
                len += str.charCodeAt(i) < 0 || str.charCodeAt(i) > 255 ? (this.charset.toLowerCase() === 'utf-8' ? 3 : 2) : 1;
                if (len > maxlen) {
                    ret += dot; // 如果超过长度的时候，ret截取字符串再带上...
                    break;
                }
                ret += str.substr(i, 1); // 每次从i位置截取1个字符给ret
            }
            return ret;
        },
        /**
         * 计算当前还可以输入字符数函数。
         * 只有纯数字和英文才算1个length，其他字符全部当作2字符处理。
         * @param obj obj.value是当前输入的内容字符串
         * @param showId 结果显示到DOM结构的id
         * @param maxlen 最大可以输入的字符数，这是英文字符长度
         */
        strLenCalc: function (obj, showId, maxlen) {
            var v = obj.value,
                maxlen = !maxlen ? 200 : maxlen,
                curlen = maxlen,
                len = this.strlen(v); // 默认可以输入200字符
            for (var i = 0; i < v.length; i++) {
                if (v.charCodeAt(i) < 0 || v.charCodeAt(i) > 127) {
                    curlen -= 2; // 其余字符全部算2个字符
                } else {
                    curlen -= 1; // 纯英文、数字、标点、控制字符、括号等算1个字符
                }
            }
            return Math.floor(curlen / 2); // 显示还可以输入的字符数
        },
        /**
         * html格式文本编码成转义html格式。
         * @param String text 要转义编码的html文本
         * @return String 编码后的html文本
         */
        htmlEncode: function (text) {
            return text.replace(/&/g, '&amp').replace(/"/g, '&quot;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
        },
        /**
         * 转义html格式文本解码成html格式。
         * @param String text 要解码的转义html文本
         * @return String 转义成正确的html格式文本
         */
        htmlDecode: function (text) {
            return text.replace(/&amp;/g, '&').replace(/&quot;/g, '/"').replace(/&lt;/g, '<').replace(/&gt;/g, '>');
        },
    },
    Array: {
        /**
         * 检测数组中是否存在已知字符串或数字。
         * @param needle 要查询的字符串|数字
         * @param haystack 要搜索的数组
         */
        in_array: function (needle, haystack) {
            if (typeof needle == 'string' || typeof needle == 'number') {
                for (var i in haystack) {
                    if (haystack[i] == needle) {
                        return true;
                    }
                }
            }
            return false;
        },
    },
    // 对象处理类
    Object: {
        /**
         * 判断对象是否为空。
         * 实现思路：巧妙的利用了for循环，如果循环了代表对象不空，return false；没进入循环return true
         * @param obj 要检查是否为空的对象
         */
        isObjectEmpty: function (obj) {
            for (i in obj) {
                return false;
            }
            return true;
        },
        /**
         * 按照key名从对象中取出值。
         * @param key
         * @param obj
         * @returns {*}
         */
        fetchValueByKey: function (key, obj) {
            if (this.keyInObject(key, obj)) return obj[key];
            return false;
        },
        /**
         * 检测对象中是否存在key键值。
         * @param key
         * @param obj
         * @returns {boolean}
         */
        keyInObject: function (key, obj) {
            for (var eveKey in obj) {
                if (key == eveKey) return true;
            }
            return false;
        },
        /**
         * 切割二维字符串变成KV形式的对象，二维结构key不能空，空了直接返回false不进行解析，切割符不匹配也返回false不解析
         * @param originStr 等切割字符串
         * @param arraySplitSymbol 第一维切割符
         * @param KVSplitSymbol 第二维切割符
         * @returns {*}
         */
        splitStrIntoKVObj: function (originStr, arraySplitSymbol, KVSplitSymbol) {
            var firstResultArray = [],
                secondResultObj = {};

            firstResultArray = originStr.split(arraySplitSymbol); // 按第一个切割符号从一维切开
            // 只对基本参数关键字段做校验
            for (var i = 0; i < firstResultArray.length; i++) {
                var tempArray = firstResultArray[i].split(KVSplitSymbol); // 按照第二个切割符号继续切开
                if (tempArray[0] && tempArray.length == 2) {
                    // 必须保证key不能为空，才是有效数据
                    var cKey = tempArray[0],
                        cValue = tempArray[1];
                    secondResultObj[cKey] = cValue;
                } else {
                    return false; // key空了直接不解析
                }
            }
            console.log(secondResultObj);
            return secondResultObj;
        },
        /**
         * 转成json方式。
         * @param obj
         */
        toJson: function (obj) {
            return JSON.stringify(obj);
        }
    },
    // 日期处理类
    Date: {
        /**
         * 将当前字符串转成日期（暂时未调通）
         * @param formatStr
         * @returns {*}
         */
        strFormatToDate: function (formatStr) {
            var str = formatStr;
            var Week = ['日', '一', '二', '三', '四', '五', '六'];

            str = str.replace(/yyyy|YYYY/, formatStr.getFullYear());
            str = str.replace(/yy|YY/, (formatStr.getYear() % 100) > 9 ? (formatStr.getYear() % 100).toString() : '0' + (formatStr.getYear() % 100));

            str = str.replace(/MM/, formatStr.getMonth() > 9 ? formatStr.getMonth().toString() : '0' + formatStr.getMonth());
            str = str.replace(/M/g, formatStr.getMonth());

            str = str.replace(/w|W/g, Week[formatStr.getDay()]);

            str = str.replace(/dd|DD/, formatStr.getDate() > 9 ? formatStr.getDate().toString() : '0' + formatStr.getDate());
            str = str.replace(/d|D/g, formatStr.getDate());

            str = str.replace(/hh|HH/, formatStr.getHours() > 9 ? formatStr.getHours().toString() : '0' + formatStr.getHours());
            str = str.replace(/h|H/g, formatStr.getHours());
            str = str.replace(/mm/, formatStr.getMinutes() > 9 ? formatStr.getMinutes().toString() : '0' + formatStr.getMinutes());
            str = str.replace(/m/g, formatStr.getMinutes());

            str = str.replace(/ss|SS/, formatStr.getSeconds() > 9 ? formatStr.getSeconds().toString() : '0' + formatStr.getSeconds());
            str = str.replace(/s|S/g, formatStr.getSeconds());

            return str;
        },
        /**
         * 将日期解析成数组
         * @param date
         * @returns {*}
         */
        dateToArray: function (date) {
            var myArray = Array();
            myArray[0] = date.getFullYear();
            myArray[1] = date.getMonth();
            myArray[2] = date.getDate();
            myArray[3] = date.getHours();
            myArray[4] = date.getMinutes();
            myArray[5] = date.getSeconds();
            return myArray;
        },
        /**
         * 取得当前日期所在月的最大天数（暂时未调通）
         * @param date
         * @returns {*}
         * @constructor
         */
        maxDayOfCurrentMonth: function (date) {
            var ary = this.dateToArray(date);
            var date1 = (new Date(ary[0], ary[1] + 1, 1));
            var date2 = date1.dateAdd(1, 'm', 1);
            var result = dateDiff(date1.Format('yyyy-MM-dd'), date2.Format('yyyy-MM-dd'));
            return result;
        },
        /**
         * 字符串转成日期类型
         * 格式 MM/dd/YYYY MM-dd-YYYY YYYY/MM/dd YYYY-MM-dd
         * @param DateStr
         * @returns {Date}
         * @constructor
         */
        stringToGMTDate: function (DateStr) {
            var converted = Date.parse(DateStr);
            var myDate = new Date(converted);
            if (isNaN(myDate)) {
                var arys = DateStr.split('-');
                myDate = new Date(arys[0], --arys[1], arys[2]);
            }
            return myDate;
        },
        /**
         * 获取当前时间，标准格式。
         * @param milliseconds 是否要显示毫秒
         * @returns {string}
         */
        getStdCurrentTime: function (milliseconds) {
            var now = new Date();

            var year = now.getFullYear();       // 年
            var month = now.getMonth() + 1;     // 月
            var day = now.getDate();            // 日

            var hh = now.getHours();            // 时
            var mm = now.getMinutes();          // 分
            var ss = now.getSeconds();          // 秒

            var ms = now.getMilliseconds();     // 毫秒

            var clock = year + "-";

            if (month < 10)
                clock += "0";
            clock += month + "-";

            if (day < 10)
                clock += "0";
            clock += day + " ";

            if (hh < 10)
                clock += "0";
            clock += hh + ":";

            if (mm < 10) clock += "0";
            clock += mm + ":";

            if (ss < 10) clock += "0";
            clock += ss;

            if (milliseconds) {
                clock += ":" + ms;
            }

            return clock;
        },
        /**
         * 获取当前GMT格式的时间
         * @param fullTime 需要显示全部信息
         * @returns {string}
         */
        getStdPlusCurrentTime: function (fullTime) {
            var myDate = new Date();
            myDate.getYear();        //获取当前年份(2位)
            myDate.getFullYear();    //获取完整的年份(4位,1970-????)
            myDate.getMonth();       //获取当前月份(0-11,0代表1月)
            myDate.getDate();        //获取当前日(1-31)
            myDate.getDay();         //获取当前星期X(0-6,0代表星期天)
            myDate.getTime();        //获取当前时间(从1970.1.1开始的毫秒数)
            myDate.getHours();       //获取当前小时数(0-23)
            myDate.getMinutes();     //获取当前分钟数(0-59)
            myDate.getSeconds();     //获取当前秒数(0-59)
            myDate.getMilliseconds();    //获取当前毫秒数(0-999)
            myDate.toLocaleDateString();     //获取当前日期
            if (fullTime) {
                return myDate.toLocaleString();        //获取日期与时间
            } else {
                return myDate.toLocaleTimeString();     //获取当前时间
            }
        },
        /**
         * 日期间隔函数
         * @param dateBegin 起始日期
         * @param dateEnd 结束日期
         * @returns {number}
         */
        getDateDiff: function (dateBegin, dateEnd) {
            var dateSeg = "-", oDate1, oDate2;
            oDate1 = dateBegin.split(dateSeg);
            oDate2 = dateEnd.split(dateSeg);
            var startSecond = new Date(oDate1[0], oDate1[1] - 1, oDate1[2]);
            var endSecond = new Date(oDate2[0], oDate2[1] - 1, oDate2[2]);
            return ~~Math.abs((endSecond - startSecond) / 1000 / 60 / 60 / 24);
        },
        getLocalTime: function (ms, day) {
            if (!ms) {
                return "";
            }
            ms = Number(ms);
            var _date = new Date(ms);
            var year = _date.getFullYear(),
                month = _date.getMonth() + 1,
                date = _date.getDate(),
                hour = _date.getHours(),
                minute = _date.getMinutes(),
                second = _date.getSeconds();
            return year + "-" + (month < 10 ? ("0" + month) : month) + "-" + (date < 10 ? ("0" + date) : date) + (!day ? (" " + (hour < 10 ? ("0" + hour) : hour) + ":" + (minute < 10 ? ("0" + minute) : minute) + ":" + (second < 10 ? ("0" + second) : second)) : "");
        },
        /**
         * 本地时间转成Unix时间
         * @param localTime
         * @returns {*}
         */
        localTimeToUnixTime: function (localTime) {
            if (!localTime) {
                return "";
            }
            var newstr = localTime.replace(/-/g, '/');
            var date = new Date(newstr);
            return date.getTime();
        },
    },
    // 公共处理类
    Common: {
        // 切割一维数组并检查是否存在这个字段
        splitAndSearchFieldOne: function (originStr, searchField, splitSymbol) {
            var resultArray = originStr.split(splitSymbol),
                existFlag = false;
            for (var i = 0; i < resultArray.length; i++) {
                if (searchField == resultArray[i]) {
                    existFlag = true;
                    break;
                }
            }
            return existFlag;
        }
    },
    // 等待框
    MLoading: {
        _preventDefault: "javascript:void(0)",
        _notExist: function (checkObj) {
            return (typeof checkObj == "undefined")
        },
        _initDefaultDepthOnce: function () {
            if (this._notExist(window._dlgBaseDepth)) {
                window._dlgBaseDepth = 900 // 没有定义对话框深度,默认900
            }
        },
        _createModal: function () {
            var mModalHtml = '<div class="mModal"><a href="' + this._preventDefault + '"></a></div>';
            document.querySelector("body").insertAdjacentHTML("beforeEnd", mModalHtml);
            mModalHtml = null;
            var lastModal = document.querySelector(".mModal:last-of-type"); // 使用最后一个遮罩层
            if (document.querySelectorAll(".mModal").length > 1) {
                lastModal.style.opacity = 0.01 // 已经有遮罩不覆盖
            } else {
                lastModal.style.opacity = 0.2; // 新弹遮罩0.2透明度
            }
            // 遮罩宽高
            lastModal.style.width = window.innerWidth + "px";
            //lastModal.style.height = window.innerHeight + "px"; // 可见区域
            lastModal.style.height = document.body.scrollHeight + "px"; // 网页全文遮盖
            lastModal.style.backgroundColor = "#000";
            // 遮罩定位
            lastModal.style.position = "absolute";
            lastModal.style.left = 0;
            lastModal.style.top = 0;

            lastModal.style.zIndex = window._dlgBaseDepth++; // 保证新的遮罩在最上边
            return lastModal
        },
        _showTip: function (tipInfo, autoClose) {
            if (document.querySelector(".m-tip")) {
                document.querySelector(".m-tip .m-lcont").innerHTML = tipInfo; // 做refresh的动作
                return
            }
            if (this._notExist(tipInfo)) {
                tipInfo = "Loading..."
            }
            if (this._notExist(autoClose)) {
                autoClose = 1000 // 提示默认1秒关闭
            }
            // 初始化对话框深度
            this._initDefaultDepthOnce();

            var bodyDOM = document.querySelector("body"),
                windowInnerWidth = window.innerWidth,
                windowInnerHeight = window.innerHeight,
                mTipHtml = '<div class="m-tip"><div class="m-lbk"><div class="m-lcont">' + tipInfo + '</div></div></div>';

            bodyDOM.insertAdjacentHTML("beforeEnd", mTipHtml); // 创建、追加Tip的DOM

            // 定位DOM
            var mTipDOM = document.querySelector(".m-tip");
            mTipDOM.style.left = 0.5 * (windowInnerWidth - mTipDOM.clientWidth) + "px";
            mTipDOM.style.top = bodyDOM.scrollTop + 0.5 * (windowInnerHeight - mTipDOM.clientHeight) + "px";

            // 自动关闭
            setTimeout(function () {
                document.body.removeChild(mTipDOM);
            }, autoClose * 1000);
        },
        _showLoading: function (tipContent, isShowModal) {
            // 规避已经弹出
            if (document.querySelector("#mLoading")) {
                return
            }
            if (this._notExist(tipContent)) {
                tipContent = ""
            }
            if (this._notExist(isShowModal)) {
                isShowModal = false // 默认不弹出遮罩层
            }
            // 初始化对话框深度
            this._initDefaultDepthOnce();

            var bodyDOM = document.querySelector("body"),
                windowInnerWidth = window.innerWidth,
                windowInnerHeight = window.innerHeight,
                mLoadingHtml = null,
                mLoadingModal = null;

            // 需要遮罩
            if (isShowModal) {
                mLoadingModal = this._createModal(); // 创建Modal层
                mLoadingModal.id = "mLoadingModal" // 标记id
            }

            // 创建、追加DOM
            mLoadingHtml = '<div id="mLoading"><div class="lbk"></div><div class="lcont">' + tipContent + "</div></div>";
            bodyDOM.insertAdjacentHTML("beforeEnd", mLoadingHtml); // 把对话框插入到body标签结束标记前

            // 定位DOM
            var mLoadingDOM = document.querySelector("#mLoading");
            mLoadingDOM.style.left = 0.5 * (windowInnerWidth - mLoadingDOM.clientWidth) + "px";
            mLoadingDOM.style.top = bodyDOM.scrollTop + 0.5 * (windowInnerHeight - mLoadingDOM.clientHeight) + "px";
            return mLoadingDOM
        },
        show: function (tipContent, isShowModal) {
            this._showLoading(tipContent, isShowModal);
        },
        hide: function () {
            var mLoading = document.querySelector("#mLoading");
            if (mLoading) {
                mLoading.parentNode.removeChild(mLoading) // 移除Loading框
            }
            var mLoadingModal = document.querySelector("#mLoadingModal");
            if (mLoadingModal) {
                mLoadingModal.parentNode.removeChild(mLoadingModal) // 移除遮罩层
            }
        },
        /**
         * Loading框存在的时候刷新等待信息
         * @param newMsg 要刷新的新消息
         */
        refreshLoadingMsg: function (newMsg) {
            if (typeof newMsg == "undefined" || newMsg == "") return;
            if (document.querySelector("#mLoading")) {
                document.querySelector("#mLoading .lcont").innerHTML = newMsg; // 刷新等待框文字
            }
        },
        showTip: function (tipInfo, autoClose) {
            this._showTip(tipInfo, autoClose);
        },
        // Loading后的提示
        tipAfterLoading: function (tipInfo, autoClose) {
            this.hide(); // 提示前先关闭等待对话框
            this.showTip(tipInfo, autoClose);
        }
    },
    // ART系列
    ART: {
        // 弹框
        showDialog: function (msg, title, okFunc) {
            var okFunc = okFunc ||
                function () {
                    console.log("点击了确定");
                }, msg = msg || "", title = title || "温馨提示", _dialog = dialog({
                title: title,
                content: msg,
                // 要显示的内容
                okValue: '确定',
                ok: okFunc
            }).showModal();
        },
        // 弱提示
        showTip: function (tips) {
            var tipDialog = dialog({
                content: tips
            }).show();
            setTimeout(function () {
                tipDialog.close().remove();
            }, 1000);
        },
    },
    // 原生XHR
    NativeXHR: {
        /**
         * 以键值对方式编码表单数据
         * @param data 要提交的数据
         * @param split 键值对KV分隔符
         * @returns {*}
         */
        encodeFormData: function (data, split) {
            var split = split || "&"; // 默认用&符号
            if (!data) return ""; // 返回字符串
            var pairs = []; // 键值对
            for (var name in data) {
                if (!data.hasOwnProperty(name)) continue;
                if (typeof data[name] === "function") continue;
                var value = data[name].toString();
                name = encodeURIComponent(name.replace("%20", "+")); // 编码name
                value = encodeURIComponent(value.replace("%20", "+")); // 编码value
                pairs.push(name + "=" + value);
            }
            return pairs.join(split); // 连接键值对
        },
        /**
         * 原生js使用表单编码数据发起一个HTTP GET请求
         * @param url
         * @param data
         * @param callback
         */
        get: function (url, data, callback) {
            var request = null;
            // 创建请求
            if (window.XMLHttpRequest) {
                request = new XMLHttpRequest(); // 浏览器版本较新
            } else {
                request = new ActiveXObject('Microsoft.XMLHTTP'); // IE6及其以下版本浏览器
            }
            request.open("GET", url + "?" + this.encodeFormData(data)); // GET方式
            request.onreadystatechange = function () {
                if (request.readyState === 4 && callback) callback(request); // 回调
            }
            request.send(null); // 发送请求
        },
        /**
         * 原生js使用表单编码数据发起HTTP POST请求
         * @param url
         * @param data
         * @param callback 回调函数
         */
        post: function (url, data, callback, type) {
            var type = type || "json";
            var request = null;
            // 创建请求
            if (window.XMLHttpRequest) {
                request = new XMLHttpRequest(); // 浏览器版本较新
            } else {
                request = new ActiveXObject('Microsoft.XMLHTTP'); // IE6及其以下版本浏览器
            }
            request.open("POST", url); // 打开连接

            request.onreadystatechange = function () {
                if (request.readyState === 4 && request.status === 200) {
                    // 获得响应的类型，采用不同的方式响应
                    var type = request.getResponseHeader("Content-Type");
                    if (type.indexOf("xml") !== -1 && request.responseXML) {
                        // Document对象
                        callback(request.responseXML, request);
                    } else if (type === "application/json") {
                        // json对象
                        var response = JSON.parse(request.responseText); // 解析Json
                        callback(response, request);
                    } else {
                        // 字符串响应方式
                        callback(request.responseText, request);
                    }
                }
            }

            // 区分不同类型
            if (type == "json") {
                request.setRequestHeader("Content-Type", "application/json");
                request.send(JSON.stringify(data)); // json格式
            } else {
                request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                request.send(this.encodeFormData(data)); // 表单编码
            }
        },
        // ajax请求,要定义钩子
        ajax: function (url, data, opts) {
            var xhr = {}; // 允许多线程提交
            var opts = opts || {},
                requestIndex = opts.requestIndex || 0;

            var XHROpts = {
                isUpload: opts.isUpload || false, // 是否上传文件
                contentType: opts.isUpload ? false : 'application/x-www-form-urlencoded', // 请求头
                type: data ? 'POST' : 'GET',
                dataType: opts.dataType || 'json', // 默认json
                // 请求开始
                loadStart: function () {
                    // 回调钩子
                    if (typeof opts.loadStart == "function") {
                        opts.beforeSend();
                    }
                },
                // 进度控制
                progress: function (e) {
                    // 回调钩子
                    if (typeof opts.progress == "function") {
                        opts.progress(e); // e.lengthComputable/e.loaded/e.total可以做进度事件
                    }
                },
                // 请求完成
                load: function (result, XHR) {
                    // 回调钩子
                    if (typeof opts.success == "function") {
                        opts.success(result, XHR);
                    }
                },
                // 请求错误
                error: function (XHR) {
                    // 回调钩子
                    if (typeof opts.error == "function") {
                        opts.error(XHR);
                    }
                },
                // 请求终止
                abort: function (XHR) {
                    // 回调钩子
                    if (typeof opts.abort == "function") {
                        opts.error(XHR);
                    }
                },
            };

            // 执行请求前动作
            XHROpts.loadStart(); // ajax beforeSend

            // 创建请求
            if (window.XMLHttpRequest) {
                // 浏览器版本较新
                xhr[requestIndex] = new XMLHttpRequest();
            } else {
                // IE6及其以下版本浏览器
                xhr[requestIndex] = new ActiveXObject('Microsoft.XMLHTTP');
            }

            // 检测是否支持XHR2的FormData API
            if (typeof FormData === "undefined") {
                console.log("FormData未定义");
                throw new Error("FormData is not implemented.");
                return false;
            }

            // 附带表单数据
            var formData = new FormData();
            for (var name in data) {
                if (!data.hasOwnProperty(name)) continue; // 跳过继承属性
                var value = data[name];
                if (typeof value === "function") continue; // 跳过函数
                // 既允许K/V参数，也允许文件对象被赋值到K中
                formData.append(name, value);
            }
            formData.append("timestamp", Date.now()); // 最终表单附带时间戳

            // 如果是上传，并且系统支持onprogress事件
            if (opts.isUpload && "onprogress" in (new XMLHttpRequest())) {
                xhr[requestIndex].onprogress = function(e) {
                    if (typeof XHROpts.progress === "function") {
                        XHROpts.progress(e);
                    }
                }
                // 直接使用onprogress，不用监听
                //xhr[requestIndex].upload.addEventListener("progress", XHROpts.progress, false); // 非IE浏览器上传进度
                //xhr[requestIndex].upload.addEventListener("progress", XHROpts.progress, false); // IE浏览器上传进度
            }

            // 监听响应回调，解析HTTP响应：（xhr[requestIndex] === request）
            xhr[requestIndex].onreadystatechange = function () {
                if (xhr[requestIndex].readyState === 4 && xhr[requestIndex].status === 200) {
                    // 获得响应的类型，采用不同的方式响应
                    var type = xhr[requestIndex].getResponseHeader("Content-Type");
                    if (type.indexOf("xml") !== -1 && xhr[requestIndex].responseXML) {
                        // Document对象
                        if (XHROpts.load) {
                            XHROpts.load(xhr[requestIndex].responseXML, xhr[requestIndex]);
                        }
                    } else if (type === "application/json") {
                        // json对象
                        var response = JSON.parse(xhr[requestIndex].responseText); // 解析Json
                        if (XHROpts.load) {
                            XHROpts.load(response, xhr[requestIndex]);
                        }
                    } else {
                        // 字符串响应方式
                        if (XHROpts.load) {
                            XHROpts.load(xhr[requestIndex].responseText, xhr[requestIndex]);
                        }
                    }
                }
            }
            // 上边的监听回调等同于写兼容性的两句话：
            // {
            //     xhr[requestIndex].addEventListener("load", XHROpts.load, false); // 非IE浏览器，请求完成
            //     xhr[requestIndex].attachEvent("load", XHROpts.load); // IE浏览器，请求完成
            // }
            // 添加其他监听事件
            xhr[requestIndex].addEventListener("error", XHROpts.error, false); // 出错
            xhr[requestIndex].addEventListener("abort", XHROpts.abort, false); // 中止

            // 打开链路请求
            xhr[requestIndex].open(XHROpts.type, url);

            // 上传文件则send()会自动设置Content-Type头；非上传文件则设置下表单请求头
            if (! XHROpts.isUpload) {
                xhr[requestIndex].setRequestHeader("Content-Type", XHROpts.contentType);
            }

            // 发送请求
            xhr[requestIndex].send(formData);
        },
    },
    // XHR请求
    jQueryXHR: {
        // ajax请求（特别注意：如果要多线程，则使用ajax前要在别的地方init cache）
        ajax: function (url, data, opts) {
            var opts = opts || {},
                requestIndex = opts.requestIndex || 0,
                // jsXHR线程默认从0开始
                loadingTimer = null;
            opts.requestIndex = requestIndex;

            // 处理url
            url = url.indexOf('?') === -1 ? url + '?' : url + '&';
            url = url.replace(/\&resType\=[^\&]+/g, '') + 'resType=json';
            url = url.replace(/\&isAjax\=1/g, '') + '&isAjax=1';

            var ajaxOpts = {
                url: url,
                data: data,
                cache: opts.cache || false,
                // false不缓存请求
                processData: opts.isUpload,
                contentType: opts.isUpload ? false : 'application/x-www-form-urlencoded',
                type: data ? 'POST' : 'GET',
                dataType: opts.dataType || 'json',
                // 默认json
                timeout: opts.timeout || 30000,
                jsonp: opts.dataType === 'jsonp' ? 'callback' : null,
                jsonpCallback: opts.dataType === 'jsonp' ? opts.success : null,
                beforeSend: function (XHR, option) {
                    if (opts.requestIndex) {
                        if (opts.requestMode == 'block') {
                            if (jQuery.ajax._requestCache[opts.requestIndex]) {
                                return false; // XHR线程存在直接返回，不做提交
                            }
                        } else if (opts.requestMode == 'abort') {
                            if (jQuery.ajax._requestCache[opts.requestIndex]) {
                                jQuery.ajax._requestCache[opts.requestIndex].abort(); // 阻止某线程提交
                            }
                        }
                    }

                    var result = true;
                    if (typeof opts.beforeSend == 'function') {
                        result = opts.beforeSend(XHR, option, opts.requestIndex); // 执行请求前钩子，如果钩子函数return false则不提交ajax
                    }

                    // beforeSend并不一定非要返回true
                    if (result != false) {
                        jQuery.ajax._requestCache[opts.requestIndex] = XHR;
                        if (typeof opts.noDefaultLoading == "undefined" || opts.noDefaultLoading == false) {
                            loadingTimer = setTimeout(function () {
                                utils.MLoading.show(opts.loadingMsg, opts.loadingMask); // 默认ajax请求会显示等待框
                            }, 100);
                        }
                    }

                    return result;
                },
                success: function (result, textStatus, XHR) {
                    clearTimeout(loadingTimer);
                    utils.MLoading.hide();

                    if (result == null && !opts.noMsg) {
                        var msg = '您的网络有些问题，请稍后再试 [code:1]';
                        utils.MLoading.tipAfterLoading(msg);
                    }

                    if (typeof result !== 'object') {
                        result = jQuery.parseJSON(result);
                    }

                    if (typeof opts.success == 'function') {
                        opts.success(result, textStatus, XHR, opts.requestIndex); // 成功钩子带上线程id
                    }

                    if (result) {
                        // 有返回结果的情况下
                        if (result.errCode && result.errMsg) {
                            // 如果是标准格式返回情况
                            if (!opts.noMsg) {
                                // 如果需要提示
                                if (result.errCode == 0) {
                                    // 标准返回结果正确
                                    utils.MLoading.tipAfterLoading(result.errMsg);
                                } else {
                                    // 错误结果提示
                                    var msg = result.errMsg + '<span style="display:none;">' + result.errCode + '</span>';
                                    utils.MLoading.tipAfterLoading(result.errMsg);
                                }
                            }
                        } else {
                            // 数据格式解析失败，返回的不是标准格式
                            if (!opts.noMsg) {
                                // 如果需要提示，告知数据解析失败
                                var msg = '数据解析失败，请稍后再试 [code:2]';
                                utils.MLoading.tipAfterLoading(msg);
                            }
                        }
                    }

                },
                error: function (XHR, textStatus, errorThrown) {
                    clearTimeout(loadingTimer);
                    utils.MLoading.hide();

                    if (XHR.readyState == 0 || XHR.status == 0) {
                        if (!opts.noMsg) {
                            var msg = '您的网络有些问题，请稍后再试[code:4]';
                            utils.MLoading.tipAfterLoading(msg);
                        }
                    } else if (textStatus != 'abort' && !opts.noMsg) {
                        if (!opts.noMsg) {
                            var msg = '';
                            switch (textStatus) {
                                case 'timeout':
                                    msg = '对不起，请求服务器网络超时';
                                    break;
                                case 'error':
                                    msg = '网络出现异常，请求服务器错误';
                                    break;
                                case 'parsererror':
                                    msg = '网络出现异常，服务器返回错误';
                                    break;
                                case 'notmodified':
                                default:
                                    msg = '您的网络有些问题，请稍后再试[code:3]';
                            }
                            utils.MLoading.tipAfterLoading(msg);
                        }
                    }
                    if (typeof opts.error == 'function') {
                        opts.error(XHR, textStatus, errorThrown, opts.requestIndex); // 执行钩子带上请求id
                    }
                },
                complete: function (XHR, status) {
                    if (opts.requestIndex) {
                        if (jQuery.ajax._requestCache[opts.requestIndex]) {
                            jQuery.ajax._requestCache[opts.requestIndex] = null; // 如果使用多线程提交，回收该线程
                        }
                    }
                    if (typeof opts.complete == 'function') {
                        opts.complete(XHR, status, opts.requestIndex); // 执行完成钩子
                    }
                }
            };
            jQuery.ajax(ajaxOpts);

            return false;
        },
    },
    // 插件类
    Plugin: {
        // 粘贴板
        Zclip: {
            copySuccess: function () { /* 复制成功后的操作 */
                var $copysuc = $("<div class='copy-tips'><div class='copy-tips-wrap'>复制成功</div></div>");
                $("body").find(".copy-tips").remove().end().append($copysuc);
                $(".copy-tips").fadeOut(3000);
            }
        }
    },
    // jquery扩展
    jQueryExtension: {
        init: function () {
            jQuery.extend(jQuery.ajax, {
                _requestCache: {}
            }); // 扩展jQuery ajax多缓存

            jQuery.extend({
                os: {
                    ios: false,
                    android: false,
                    version: false
                }
            }); // 扩展当前用户操作系统

            var ua = navigator.userAgent;
            var browser = {},
                weixin = ua.match(/MicroMessenger\/([^\s]+)/),
                webkit = ua.match(/WebKit\/([\d.]+)/),
                android = ua.match(/(Android)\s+([\d.]+)/),
                ipad = ua.match(/(iPad).*OS\s([\d_]+)/),
                ipod = ua.match(/(iPod).*OS\s([\d_]+)/),
                iphone = !ipod && !ipad && ua.match(/(iPhone\sOS)\s([\d_]+)/),
                webos = ua.match(/(webOS|hpwOS)[\s\/]([\d.]+)/),
                touchpad = webos && ua.match(/TouchPad/),
                kindle = ua.match(/Kindle\/([\d.]+)/),
                silk = ua.match(/Silk\/([\d._]+)/),
                blackberry = ua.match(/(BlackBerry).*Version\/([\d.]+)/),
                mqqbrowser = ua.match(/MQQBrowser\/([\d.]+)/),
                chrome = ua.match(/CriOS\/([\d.]+)/),
                opera = ua.match(/Opera\/([\d.]+)/),
                safari = ua.match(/Safari\/([\d.]+)/);
            // H5 mobile
            if (weixin) {
                jQuery.os.wx = true;
                jQuery.os.wxVersion = weixin[1];
                utils.Browser.userAgent = "weixin" + weixin[1];
            }
            // if (browser.webkit = !! webkit) browser.version = webkit[1]
            if (android) {
                jQuery.os.android = true;
                jQuery.os.version = android[2];
                utils.Browser.userAgent = "android" + android[2];
            }
            if (iphone) {
                jQuery.os.ios = jQuery.os.iphone = true;
                jQuery.os.version = iphone[2].replace(/_/g, '.');
                utils.Browser.userAgent = "iphone" + iphone[2].replace(/_/g, '.');
            }
            if (ipad) {
                jQuery.os.ios = jQuery.os.ipad = true;
                jQuery.os.version = ipad[2].replace(/_/g, '.');
                utils.Browser.userAgent = "ipad" + ipad[2].replace(/_/g, '.');
            }
            if (ipod) {
                jQuery.os.ios = jQuery.os.ipod = true;
                jQuery.os.version = ipod[2].replace(/_/g, '.');
                utils.Browser.userAgent = "ipod" + ipod[2].replace(/_/g, '.');
            }
            // Browser
            if (mqqbrowser) {
                utils.Browser.userAgent = "mqqbrowser";
            }
            if (chrome) {
                utils.Browser.userAgent = "chrome";
            }
            if (opera) {
                utils.Browser.userAgent = "opera";
            }
            if (safari) {
                utils.Browser.userAgent = "safari";
            }
            // 网络类型定义
            window.NETTYPE = 0;
            window.NETTYPE_FAIL = -1;
            window.NETTYPE_WIFI = 1;
            window.NETTYPE_EDGE = 2;
            window.NETTYPE_3G = 3;
            window.NETTYPE_DEFAULT = 0;
        }
    }
}