$(function(){
	window.requestAnimFrame = (function(){
      return  window.requestAnimationFrame       || 
              window.webkitRequestAnimationFrame || 
              window.mozRequestAnimationFrame    || 
              window.oRequestAnimationFrame      || 
              window.msRequestAnimationFrame     || 
              function( callback ){
              window.setTimeout(callback, 1000 / 60);
              };
    })();
	
	setTimeout(function() {
	/****跟随滚动缓动运动动画***/
	var Ainm_RAF;
	var Scroll_Top = 0;
	var Scroll_Tr = $(".Scroll_Tr");
	var Scroll_B = $(".Scroll_B");
	var State_now = 0;
	var Duration = 120;
	var t = 0;
	
	
	function ResizeO() {
		winHeight = document.documentElement.clientHeight;
		winWidth = document.documentElement.clientWidth;
		var Container_H = Scroll_Tr.height();
		Scroll_B.height(Container_H);
		Scroll_Top = $(window).scrollTop();
		Scroll_Tr.data("state",Scroll_Top);
		};
	
	function Smooth_Scroll() {
		State_now = Scroll_Tr.data("state");
		Scroll_Top = $(window).scrollTop();
		Disten = Scroll_Top - State_now;
		t = 0;
		cancelAnimationFrame(Ainm_RAF);
		Ainm_RAF = requestAnimationFrame(Smooth_Anim);
		};
		
	function Smooth_Anim() {
		if( t<Duration )
		{
			Tr_ease_e = Tween.Expo.easeOut( t , State_now , Disten , Duration );
			Tr_ease = Math.round(Tr_ease_e);
			Scroll_Tr.css("transform","translate3d(0px,"+ -(Tr_ease) +"px,0px)");
			var NND = Tr_ease ;
			Scroll_Tr.data("state",NND);
			t++;
			}
		else if( t=Duration )
		{
			//haha
			}
		Ainm_RAF = requestAnimationFrame(Smooth_Anim);
		};
	
	
	ResizeO();
	Smooth_Scroll();
	Ainm_RAF = requestAnimationFrame(Smooth_Anim);
	
	
	$(window).on('resize',function() {
        ResizeO();
		Smooth_Scroll();
    });
	$(window).on('scroll',function() {
        Smooth_Scroll();
		ResizeO();
    });
	$(window).on('click',function() {
        ResizeO();
    });
	},150);
	/****跟随滚动缓动运动动画***/

	});