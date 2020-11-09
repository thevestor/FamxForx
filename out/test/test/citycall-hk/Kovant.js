/******************************************
***										***
***				页面效果				***
***										***
******************************************/
$(function() {
  setTimeout(function(){
     $('#wrapper').addClass('transformlate');
   },1000);
  //监听滚动条添加CLASS
	var waypoint = new Waypoint({
	  element: $('.kovant_main02'),
	  handler: function(direction) {
		  if(direction == 'down'){
         var me = $('.kovant_main02 li:nth-child(1)');
            me.queue("fx", []);
            me.delay (100).queue (function (){
                me.addClass('spaceInDown').show();
            });
         var me2 = $('.kovant_main02 li:nth-child(2)');
            me2.queue("fx", []);
            me2.delay (400).queue (function (){
                me2.addClass('spaceInDown').show();
            });   
         var me3 = $('.kovant_main02 li:nth-child(3)');
            me3.queue("fx", []);
            me3.delay (700).queue (function (){
                me3.addClass('spaceInDown').show();
            });
         var me4 = $('.kovant_main02 li:nth-child(1) .as-background');
            me4.queue("fx", []);
            me4.delay (500).queue (function (){
                me4.addClass('vanishIn').show();
            });
         var me5 = $('.kovant_main02 li:nth-child(2) .as-background');
            me5.queue("fx", []);
            me5.delay (700).queue (function (){
                me5.addClass('perspectiveDownRetourn').show();
            });

		    }else{
         $('.kovant_main02 li').removeClass('spaceInDown');
			 $('.kovant_main02 li:nth-child(1) .as-background').removeClass('vanishIn');
		    $('.kovant_main02 li:nth-child(2) .as-background').removeClass('perspectiveDownRetourn');
		}
	  },
	  offset: '78%' 
	});	
	
	var waypoint = new Waypoint({
	  element: $('.kovant_main03'),
	  handler: function(direction) {
		  if(direction == 'down'){
			$('.kovant_main03 .copy').addClass('zoomIn');
		  }else{
			$('.kovant_main03 .copy').removeClass('zoomIn');
		}
	  },
	  offset: '35%' 
	});	
	
	var waypoint = new Waypoint({
	  element: $('.kovant_main04'),
	  handler: function(direction) {
		  if(direction == 'down'){
			var pr = $('.kovant_main04 li:nth-child(1)');
            pr.queue("fx", []);
            pr.delay (100).queue (function (){
                pr.addClass('spaceInLeft').show();
            });
         var pr2 = $('.kovant_main04 li:nth-child(2)');
            pr2.queue("fx", []);
            pr2.delay (400).queue (function (){
                pr2.addClass('spaceInLeft').show();
            });   
         var pr3 = $('.kovant_main04 li:nth-child(3)');
            pr3.queue("fx", []);
            pr3.delay (700).queue (function (){
                pr3.addClass('spaceInLeft').show();
            });
		  }else{
			$('.kovant_main04 li').removeClass('spaceInLeft');
		}
	  },
	  offset: '30%' 
	});	
	
});
//初始化缓动Scroll
skrollr.init({
	forceHeight: false
});

//幻灯片切换
$(document).ready(function() {
		var slider = new bootslider('#bootslider', {
			animationIn: "fadeInUp",
			animationOut: "flipOutX",
			timeout: 5000,
			autoplay: true,
			preload: true,
			pauseOnHover: false,
			thumbnails: false,
			pagination: false,
			mousewheel: false,
			keyboard: true,
			touchscreen: true,
			layout: 'fixedheight-center',
			canvas: {
				width: 1920,
				height: 920
			}
		});
		slider.init();
});

//背景过渡JS
(function() {
  // Fake loading.
			setTimeout(init, 1000);
			function init() {	
				var scrollElemToWatch_1 = document.getElementById('rev-3'),
					watcher_1 = scrollMonitor.create(scrollElemToWatch_1, -300),				
					rev3 = new RevealFx(scrollElemToWatch_1, {
						revealSettings : {
							bgcolor: '#0cbbfe',
							direction: 'rl',
                   delay: 800,
							onCover: function(contentEl, revealerEl) {
								contentEl.style.opacity = 1;
							}
						}
					}),
					rev4 = new RevealFx(document.querySelector('#rev-4'), {
						revealSettings : {
							bgcolor: '#22f3f5',
							delay: 1600,
							onCover: function(contentEl, revealerEl) {
								contentEl.style.opacity = 1;
							}
						}
					}),
					rev5 = new RevealFx(document.querySelector('#rev-5'), {
						revealSettings : {
							bgcolor: '#ffd0d0',
							delay: 2400,
							onCover: function(contentEl, revealerEl) {
								contentEl.style.opacity = 1;
							}
						}
					}),

					scrollElemToWatch_2 = document.getElementById('rev-6'),
					watcher_2 = scrollMonitor.create(scrollElemToWatch_2, -300),
					rev6 = new RevealFx(scrollElemToWatch_2, {
						revealSettings : {
							bgcolor: '#c4ef4e',
							onCover: function(contentEl, revealerEl) {
								contentEl.style.opacity = 1;
							}
						}
					}),
					rev7 = new RevealFx(document.querySelector('#rev-7'), {
						revealSettings : {
							bgcolor: '#ffdc38',
							direction: 'rl',
							delay: 250,
							onCover: function(contentEl, revealerEl) {
								contentEl.style.opacity = 1;
							}
						}
					}),
					rev8 = new RevealFx(document.querySelector('#rev-8'), {
						revealSettings : {
							bgcolor: '#7f40f1',
							direction: 'rl',
							delay: 500,
							onCover: function(contentEl, revealerEl) {
								contentEl.style.opacity = 1;
							}
						}
				});

				watcher_1.enterViewport(function() {
					rev3.reveal();
					rev4.reveal();
					rev5.reveal();
					watcher_1.destroy();
				});
				watcher_2.enterViewport(function() {
					rev6.reveal();
					rev7.reveal();
					rev8.reveal();
					watcher_2.destroy();
				});


				//************************ Example 3 - api examples ********************************

			}
})();