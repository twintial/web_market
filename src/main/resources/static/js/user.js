function login(form_id) {
    let login_success = function (response) {
        if (response.code === 200) {
            alert("登陆成功!");
            window.location.href = "/";
        } else {
            alert(response.message)
        }
    };
    let login_fail = function () {
        alert("登陆失败!")
    };
    ajax_post("/user/login", form2Json(form_id), login_success, login_fail)
}

function register(form_id) {
    let register_success = function (response) {
        if (response.code === 200) {
            alert("注册成功!");
            window.location.href = "/login";
        } else {
            alert(response.message)
        }
    };
    let register_fail = function () {
        alert("注册失败!")
    };
    ajax_post("/user/register", form2Json(form_id), register_success, register_fail)
}