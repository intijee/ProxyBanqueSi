/**
 * 
 */
$('.nav').on('click', 'li', function(){
    $('.nav li').removeClass('active');
    $(this).addClass('active');
});