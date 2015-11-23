
// Search form on main page
$("#search-form").focusin(function(){
    $("#search-suggestions").css('display', 'block');
});
$("#search-form").focusout(function(){
    $("#search-suggestions").css('display', 'none');
});

//
