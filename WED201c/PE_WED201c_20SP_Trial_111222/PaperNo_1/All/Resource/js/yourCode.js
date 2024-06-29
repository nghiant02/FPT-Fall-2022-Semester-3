document.getElementById("myform").style.display = "none"
function Show() {
    var a = document.getElementById("mytext")
    if (a.innerHTML === " Show Register Form ") {
        document.getElementById("myform").style.display = "block"
        a.innerHTML = " Hide Register Form "
    } else {
        a.innerHTML = " Show Register Form "
        document.getElementById("myform").style.display = "none"
    }
}
function checkForm() {
    var a = document.getElementById("t1").value;
    var b = document.getElementById("t2").value;
    if(a.length === 0 || b.length === 0)
    {
        alert("Name and email can't be empty!")
    }else
    {
        alert("Your infomation have been save!")
    }
}