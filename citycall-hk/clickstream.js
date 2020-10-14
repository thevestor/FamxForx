/**
* author： zhaojun(jufeng)
**/

function Cs(param){
   this.autoP = param.autoP || true
   //构建did
   var did = this.checkCookie()
   param.did = did
   //构建log
   if(this.autoP){
       param.typ = "p"
       param.eid = document.title
       param.tpc = "system"// 系统默认
       param.us = this.getQueryString("utm_source") || '';
       param.um = this.getQueryString("utm_medium") || '';
       param.uc = this.getQueryString("utm_campaign") || '';
       param.uct = this.getQueryString("utm_content") || '';
       param.ut = this.getQueryString("utm_term") || '';
       var nowWd = this.getSearchUrlKeyWord() || '';
       var nowSf =  this.getSearchUrl() || '';
         //说明是到落地页
         if( nowSf!=''){
             var sf = this.getCookie('sf')
              if(sf==null || sf ==''){
                //set cookie
                this.addCookie('sf',nowSf,0)
                this.addCookie('wd',nowWd,0)
              }else if( nowSf!=sf){
                  //set cookie
                  this.addCookie('sf',nowSf,0)
                  this.addCookie('wd',nowWd,0)
              }
         }
       param.sf = this.getCookie('sf') || '';
       param.wd = this.getCookie('wd') || '';
   }
  this.logData = this.getLog(param)
  if(this.autoP){
    this.autoPSend()
  }
}

Cs.prototype.stream = function(param){
    this.logData.cm.tpc = param.tpc
    //页面自定义事件，讲广告推广参数设置为空
    this.logData.cm.us = ''
    this.logData.cm.um = ''
    this.logData.cm.uc = ''
    this.logData.cm.uct = ''
    this.logData.cm.ut = ''
    this.logData.log[0].typ = 'e'   // 说明是用户自定义的事件都统一到e事件内
    this.logData.log[0].eid = param.eid
    this.logData.log[0].data = param.data
    this.send()
}

Cs.prototype.autoPSend = function(){
  this.send()
}


Cs.prototype.send = function(){
        var sid = this.logData.cm.sid;
        if(sid==null || sid==''){
            var csid = this.getCookie('c_s_id');
            if(csid==null || csid==''){
                csid = this.guid();
                this.addCookie('c_s_id',csid,0)
            }
            this.logData.cm.sid = csid;
        }
        var value = JSON.stringify(this.logData);
        console.log("--->"+value);
        var timestamp =(new Date()).valueOf();
        var sig = $.md5('300.cn' + timestamp + value + timestamp + value + timestamp + '300.cn');
        $.ajax({
                url:'https://tracing.yun300.cn/cs',
                type:'POST', //GET
                async:true,    //或false,是否异步
                data:{
                    cs: value,
                    ts: timestamp,
                    sig: sig
                },
                timeout:5000,    //超时时间
                dataType:'json',
                success:function(data,textStatus,jqXHR){
                  if(data.status == 10000) {
                    console.log('success')
                  } else {
                    console.log('error')
                  }
                },
                error:function(xhr,textStatus){
                    console.log('error')
                },
                complete:function(){
                }
            });
}

Cs.prototype.setCookie = function(c_name,value,expiredays) {
		var exdate = new Date()
		exdate.setDate(exdate.getDate()+expiredays)
		document.cookie = c_name+ "=" +escape(value)+((expiredays==null) ? "" : "; expires="+exdate.toGMTString())
}

Cs.prototype.getCookie = function(c_name) {
    if (document.cookie.length>0){
        c_start=document.cookie.indexOf(c_name + "=")
        if (c_start!=-1){
            c_start=c_start + c_name.length+1
            c_end=document.cookie.indexOf(";",c_start)
            if (c_end==-1) c_end=document.cookie.length
            return unescape(document.cookie.substring(c_start,c_end))
        }
    }
    return ""
}

Cs.prototype.checkCookie = function() {
    var did = this.getCookie('did')
    if (did!=null && did!=""){
        return did
    }else{
        did = this.guid()
        this.setCookie('did',did,30*24*60*60*1000)
    }
    return did
}

Cs.prototype.S4 = function () {
  return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
}
Cs.prototype.guid  =function() {
  return (this.S4()+this.S4()+"-"+this.S4()+"-"+this.S4()+"-"+this.S4()+"-"+this.S4()+this.S4()+this.S4());
}

Cs.prototype.getLog = function(config){
  return   {
                cm:{
                    aid:config.aid,
                    ver:"1",
                    clt:config.clt,
                    pf:config.pf,																		// 传 不为空
                    tpc:config.tpc,													// 传 不为空
                    did:config.did,																		// 写在cookie
                    uid:config.uid || '',														// 传 不必须
                    sid:config.sid || '',																		// 传 不必须
                    lc:config.lc || '',																	// 传 不必须
                    us: config.us || '',
                    um: config.um || '',
                    uc: config.uc || '',
                    uct: config.uct || '',
                    ut: config.ut || '',
                    sf:config.sf || '',
                    wd:config.wd || '',
                    msg:config.msg || ''
                },
                log:[
                    {
                        typ:config.typ,
                        pid:this.getUrl(),
                        ppid:decodeURI(document.referrer),
                        eid:config.eid || '',													// 传 必须
                        pno:'',															// 深度
                        net:"1",
                        sn:location.host,											// 域名
                        ct:(new Date()).getTime(),										// 时间戳
                        data: config.data || null,														// 传 不必须
                    },
                ]
                }
}

Cs.prototype.getQueryString =function(name){
      var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    	  var r = window.location.search.substr(1).match(reg);
    	  if (r != null) return decodeURI(r[2]); return null;
}

Cs.prototype.getUrl=function(){
　　　　var relUrl = decodeURI(document.location.toString())
　　　　if(relUrl.indexOf("?") != -1){
　　　　　　relUrl = relUrl.split("?")[0];
　　　　}
　　　　return relUrl;
}

//获取搜索URL
Cs.prototype.getSearchUrl =function(){
　     var relUrl = decodeURI(document.referrer.toString())
　　　　if(relUrl.indexOf("?") != -1){
　　　　　　relUrl = relUrl.split("?")[0];
　　　　}
        var name = '';
       if(relUrl.indexOf("baidu.com/link") != -1){
          name =relUrl;
       }else if(relUrl.indexOf("so.com/link") != -1){
            name = relUrl;
       }else if(relUrl.indexOf("sogou.com/link") != -1){
             name = relUrl;
       }else if(relUrl.indexOf("http://md.yun300.cn/set-sail-sdk/pc/google.com") != -1 ){
              name = relUrl;
       }else if(relUrl.indexOf("bing.com/link") != -1 ){
               name =relUrl;
       }

　　　　return name;
}


//获取搜索引擎
Cs.prototype.getSearchUrlKeyWord =function(){
       var relUrl =  "&" + document.referrer.toString().split("?")[1];
       var name = '';
       if(relUrl.indexOf("baidu.com/s") != -1){
          name = 'wd';
        }
       else if(relUrl.indexOf("so.com/s") != -1){
            name = 'q';
       }else if(relUrl.indexOf("sogou.com/sogou") != -1){
             name = 'query';
       }else if(relUrl.indexOf("google.com/search") != -1 ){
              name = 'q';
       }else if(relUrl.indexOf("bing.com/search") != -1 ){
             name = 'q';
       }else{
           name="wd"
       }
       if(name == '') {
          return null;
       }
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
     var r = relUrl.match(reg);
     if (r != null) return decodeURI(r[2]); return null;
}


Cs.prototype.addCookie = function(objName,objValue,objHours)
{
    var str = objName + "=" + escape(objValue);
    if(objHours > 0){//等于0时，关闭浏览器自动清除Cookies.
     var date = new Date();
     var ms = objHours*3600*1000;
     date.setTime(date.getTime() + ms);
     str += "; expires=" + date.toGMTString();
    }
    document.cookie = str;
   }




