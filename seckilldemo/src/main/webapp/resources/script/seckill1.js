
// js交互逻辑
var seckill ={
    //封装秒杀相关ajax的url
    URL:{

    },
    //详情页逻辑
    detail:{
        init:function (params) {
            //从cookie取手机号
            var killPhone = $.cookie('killPhone');
            //取detail.jsp页面里的参数startTimehe和endTime
            var seckillId = params['seckillId'];
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            //验证手机号
            if(!seckill.validatePhone(killPhone)){


            }

        }

    },



}