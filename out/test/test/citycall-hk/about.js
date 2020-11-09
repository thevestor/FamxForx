//背景过渡JS
(function() {
  // Fake loading.
			setTimeout(init, 2000);
			function init() {	
				var scrollElemToWatch_1 = document.getElementById('w_wbox-1517920858382'),
					watcher_1 = scrollMonitor.create(scrollElemToWatch_1, -600),				
					rev3 = new RevealFx(scrollElemToWatch_1, {
						revealSettings : {
							bgcolor: '#0cbbfe',
							direction: 'tb',
                   easing: 'easeInOutExpo',
                   delay: 500,
							onCover: function(contentEl, revealerEl) {
								contentEl.style.opacity = 1;
							}
						}
					}),
					rev4 = new RevealFx(document.querySelector('#w_wbox-1517920920340'), {
						revealSettings : {
							bgcolor: '#22f3f5',
                   easing: 'easeInOutSine',
                   direction: 'rl',
							delay: 1000,
							onCover: function(contentEl, revealerEl) {
								contentEl.style.opacity = 1;
							}
						}
					}),

					scrollElemToWatch_2 = document.getElementById('w_wbox-1517921092416'),
					watcher_2 = scrollMonitor.create(scrollElemToWatch_2, 500),
					rev5 = new RevealFx(scrollElemToWatch_2, {
						revealSettings : {
							bgcolor: '#c4ef4e',
                   easing: 'easeInOutSine',
                   delay: 1000,
							onCover: function(contentEl, revealerEl) {
								contentEl.style.opacity = 1;
							}
						}
					}),
					rev6 = new RevealFx(document.querySelector('#w_wbox-1517921294416'), {
						revealSettings : {
							bgcolor: '#ffdc38',
                   easing: 'easeInOutSine',
							direction: 'rl',
							delay: 1500,
							onCover: function(contentEl, revealerEl) {
								contentEl.style.opacity = 1;
							}
						}
				}),
                    
            scrollElemToWatch_3 = document.getElementById('w_wbox-1517921373041'),
					watcher_3 = scrollMonitor.create(scrollElemToWatch_3, -500),
					rev7 = new RevealFx(scrollElemToWatch_3, {
						revealSettings : {
							bgcolor: '#fcf652',
							direction: 'tb',
							onCover: function(contentEl, revealerEl) {
								contentEl.style.opacity = 1;
							}
						}
					});

				watcher_1.enterViewport(function() {
					rev3.reveal();
					rev4.reveal();
					watcher_1.destroy();
				});
				watcher_2.enterViewport(function() {
              rev5.reveal();
					rev6.reveal();
					watcher_2.destroy();
				});
           watcher_3.enterViewport(function() {
					rev7.reveal();
					watcher_3.destroy();
				});
				//************************ Example 3 - api examples ********************************

			}
})();