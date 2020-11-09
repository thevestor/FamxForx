$(function(){
	$("#screen").addClass("is-transition-in");
   $(".pagebox").css("opacity","0");
   $("#content_box-1519204976284,#content_box-1519441303047,#content_box-1519454382664,#content_box-1519190720844,#content_box-1519370398654").addClass("animated2 pulse");
   $("#w_wbox-1519204976284 >div,#w_wbox-1519441303047 >div,#w_wbox-1519454382664 >div,#w_wbox-1519190720844 >div,#w_wbox-1519370398654 >div").css("overflow","hidden");
});

window.onload = function(){
    setTimeout(fun,1900);
    setTimeout(fun2,800);
    setTimeout(fun3,2300);
};
  
function fun(){
   $("#screen").removeClass("is-transition-in").addClass("is-transition-out");
   $(".pagebox").css("opacity","1");
}
 function fun2(){
   $(".progress__bar").css("transform","scale(1, 1)");
}
function fun3(){
   $("#screen").fadeOut(900);
}

