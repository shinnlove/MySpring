<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/css-reset.css">
    <link rel="stylesheet" type="text/css" href="../css/utils/utils-common.css">
    <link rel="stylesheet" type="text/css" href="../css/artDialog/ui-dialog.css">
    <link rel="stylesheet" type="text/css" href="../css/randomTeam.css">
    <title>机构信息技术组团建分组</title>
</head>

<body>

<header></header>
<section class="info-container">
    <input type="hidden" name="ctoken" value="${ctoken}">
    <div class="lottery-box">
        <div class="draw" id="lottery">
            <table>
                <tr>
                    <td class="item lottery-unit lottery-unit-0">
                        <div class="img">
                            <img src="../images/dibiaozuiqiang.png" alt="">
                        </div>
                        <span class="name">地表最强组</span>
                    </td>
                    <td class="gap"></td>
                    <td class="item lottery-unit lottery-unit-1">
                        <div class="img">
                            <img src="../images/yanzhi.png" alt="">
                        </div>
                        <span class="name">颜值爆表组</span>
                    </td>
                    <td class="gap"></td>
                    <td class="item lottery-unit lottery-unit-2">
                        <div class="img">
                            <img src="../images/wuxiekeji.png" alt="">
                        </div>
                        <span class="name">无懈可击组</span>
                    </td>
                </tr>
                <tr>
                    <td class="gap-2" colspan="5"></td>
                </tr>
                <tr>
                    <td class="item lottery-unit lottery-unit-7">
                        <div class="img">
                            <img src="../images/dugu.png" alt="">
                        </div>
                        <span class="name">独孤求败</span>
                    </td>
                    <td class="gap"></td>
                    <td class=""><a class="draw-btn" href="javascript:">我要参加</a></td>
                    <td class="gap"></td>
                    <td class="item lottery-unit lottery-unit-3">
                        <div class="img">
                            <img src="../images/dugu.png" alt="">
                        </div>
                        <span class="name">独孤求败组</span>
                    </td>
                </tr>
                <tr>
                    <td class="gap-2" colspan="5"></td>
                </tr>
                <tr>
                    <td class="item lottery-unit lottery-unit-6">
                        <div class="img">
                            <img src="../images/wuxiekeji.png" alt="">
                        </div>
                        <span class="name">无懈可击组</span>
                    </td>
                    <td class="gap"></td>
                    <td class="item lottery-unit lottery-unit-5">
                        <div class="img">
                            <img src="../images/yanzhi.png" alt="">
                        </div>
                        <span class="name">颜值爆表组</span>
                    </td>
                    <td class="gap"></td>
                    <td class="item lottery-unit lottery-unit-4">
                        <div class="img">
                            <img src="../images/dibiaozuiqiang.png" alt="">
                        </div>
                        <span class="name">地表最强组</span>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div class="team-view">
        <!-- 渲染分组信息 -->
    </div>
    <div class="clearfix"></div>

</section>
<footer></footer>

<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/artDialog/dialog-min.js"></script>
<script type="text/javascript" src="../js/artTemplate/template.js"></script>
<script type="text/javascript" src="../js/utils/utils-common.js"></script>
<script type="text/javascript">
    var lottery = {
        index: -1,    //当前转动到哪个位置，起点位置
        count: 8,     //总共有多少个位置
        timer: 0,     //setTimeout的ID，用clearTimeout清除
        speed: 20,    //初始转动速度
        times: 0,     //转动次数
        cycle: 50,    //转动基本次数：即至少需要转动多少次再进入抽奖环节
        prize: -1,    //中奖位置
        init: function (id) {
            if ($('#' + id).find('.lottery-unit').length > 0) {
                $lottery = $('#' + id);
                $units = $lottery.find('.lottery-unit');
                this.obj = $lottery;
                this.count = $units.length;
                $lottery.find('.lottery-unit.lottery-unit-' + this.index).addClass('active');
            }
            ;
        },
        roll: function () {
            var index = this.index;
            var count = this.count;
            var lottery = this.obj;
            $(lottery).find('.lottery-unit.lottery-unit-' + index).removeClass('active');
            index += 1;
            if (index > count - 1) {
                index = 0;
            }
            ;
            $(lottery).find('.lottery-unit.lottery-unit-' + index).addClass('active');
            this.index = index;
            return false;
        },
        stop: function (index) {
            this.prize = index;
            return false;
        }
    };

    function roll() {
        lottery.times += 1;
        lottery.roll(); //转动过程调用的是lottery的roll方法，这里是第一次调用初始化

        if (lottery.times > lottery.cycle + 10 && lottery.prize == lottery.index) {
            clearTimeout(lottery.timer);
            lottery.prize = -1;
            lottery.times = 0;
            click = false;
        } else {
            if (lottery.times < lottery.cycle) {
                lottery.speed -= 10;
            } else if (lottery.times == lottery.cycle) {
                //                    var index = Math.random() * (lottery.count) | 0; //静态演示，随机产生一个奖品序号，实际需请求接口产生

                // 请求服务端
                var url = "randomSelect.json",
                    params = {
                        empId: empId,
                        empName: empName,
                        ctoken: $("input[name='ctoken']").val()
                    }, // 请求数据
                    opts = {
                        loadingMsg: "随机分组中...", // 自定义loading信息，也可以在beforeSend中呼出有提示信息的等待框
                        loadingMask: true, // loading遮罩
                        noMsg: true, // 不要成功或错误的解析信息
                        "beforeSend": function () {
                        }, // return false直接不提交ajax
                        "complete": function (XHR, status, requestIndex) {
                        }, // 处理完成 to do
                        "success": function (result) {
                            //console.log(result);

                            if (result.errCode == 0) {
                                lottery.prize = ~~(result.data.team_id) - 1;

                                setTimeout(function () {
                                    utils.MLoading.tipAfterLoading("你属于第" + result.data.team_id + "小组【" + result.data.team_name + "】！");
                                }, 2000);

                            } else if (result.errCode == 10001) {
                                utils.MLoading.tipAfterLoading("你已经参加过选组，请不要重复参加！");
                                lottery.prize = 0;
                                setTimeout(function () {
                                    window.location.reload();
                                }, 1500);
                            } else {
                                utils.MLoading.tipAfterLoading(result.errMsg);
                                lottery.prize = 0;
                                setTimeout(function () {
                                    window.location.reload();
                                }, 1500);
                            }

                        },
                        "error": function (XHR, status, error) {
                            utils.ART.showDialog("分组失败，请稍后再试", "温馨提示");
                        }
                    }; // 请求选项
                utils.jQueryXHR.ajax(url, params, opts);


            } else {
                if (lottery.times > lottery.cycle + 10 && ((lottery.prize == 0 && lottery.index == 7) || lottery.prize == lottery.index + 1)) {
                    lottery.speed += 110;
                } else {
                    lottery.speed += 20;
                }
            }
            if (lottery.speed < 40) {
                lottery.speed = 40;
            }
            ;
            lottery.timer = setTimeout(roll, lottery.speed); //循环调用
        }
        return false;
    }

    function queryTeamInfo() {
        // 请求服务端
        var url = "currentTeam.json",
            params = {}, // 请求数据
            opts = {
                loadingMsg: "查询分组中...",
                noDefaultLoading: true,
                loadingMask: false, // loading遮罩
                noMsg: true, // 不要成功或错误的解析信息
                "beforeSend": function () {
                }, // return false直接不提交ajax
                "complete": function (XHR, status, requestIndex) {
                }, // 处理完成 to do
                "success": function (result) {
                    var tmpl = template("team-tpl", result);
                    if (tmpl == "{Template Error}") {
                        tmpl = "啊哦，查询分组信息失败！";
                    }
                    $(".team-view").html(tmpl);
                },
                "error": function (XHR, status, error) {
//                            utils.ART.tipAfterLoading("查询分组失败，请稍后再试", "温馨提示");
                }
            }; // 请求选项
        utils.jQueryXHR.ajax(url, params, opts);
    }

    var empId, empName;
    var click = false;

    $(function () {

        // 收集员工信息
        empId = utils.URI.getQuery("empId");
        empName = decodeURI(utils.URI.getQuery("empName"));
        if (empId == null || empId == "" || typeof empId == "undefined") {
            window.location.href = "entry";
        }

        console.log(empId + ", " + empName);

        jQuery.extend(jQuery.ajax, {_requestCache: {}}); // 扩展ajax缓存

        queryTeamInfo(); // 先查询一次teamInfo

        lottery.init('lottery');

        $("body").on("click", ".draw-btn", function () {
            var _t = $(this);
            if (_t.hasClass("btn-disabled")) {
                return false;
            }
            _t.addClass("btn-disabled");

            if (click) { //click控制一次抽奖过程中不能重复点击抽奖按钮，后面的点击不响应
                return false;
            } else {
                lottery.speed = 100;
                roll(); //转圈过程不响应click事件，会将click置为false
                click = true; //一次抽奖完成后，设置click为true，可继续抽奖
                return false;
            }
        });

        // 3秒一次定时查询分组情况
        setInterval(function () {
            if (click = true) {
                queryTeamInfo();
            }
        }, 3000);

    });

</script>

<script type="text/html" id="team-tpl">
    <div class="team-list">
        <ul>
            {{each data as e i}}
            <li>
                <div class="one-team">
                    <h1 class="team-brand">{{e.team_name}}</h1>
                    <hr class="brand-hr">
                    <ul>
                        {{each e.members as t j}}
                        <li>
                            <div class="team-person">
                                <div class="avatar">
                                    <img src="https://work.alibaba-inc.com/photo/{{t.emp_id}}.50x50.jpg">
                                </div>
                                <div class="user-info">
                                    <span class="user-name">{{t.emp_name}}</span>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </li>
                        {{/each}}
                    </ul>
                    <div class="clearfix"></div>
                </div>
            </li>
            {{/each}}
            <div class="clearfix"></div>
        </ul>
    </div>
</script>
</body>
</html>