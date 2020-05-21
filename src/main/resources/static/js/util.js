// 表单转json
function form2Json(form_id) {
    let form = document.getElementById(form_id);
    let arr = {};
    for (let i = 0; i < form.elements.length; i++) {
        const feled = form.elements[i];
        switch (feled.type) {
            case undefined:
            case 'button':
            case 'file':
            case 'reset':
            case 'submit':
                break;
            case 'checkbox':
            case 'radio':
                if (!feled.checked) {
                    break;
                }
            default:
                if (arr[feled.name]) {
                    arr[feled.name] = arr[feled.name] + ',' + feled.value;
                } else {
                    arr[feled.name] = feled.value;

                }
        }
    }
    return JSON.stringify(arr);
}

// ajax封装
function ajax_post(url, data, successCallback, failCallback) {
    let xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            successCallback(JSON.parse(xmlhttp.responseText))
        }
    };
    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(data);
}

function ajax_get(url, successCallback, failCallback) {
    let xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            successCallback(JSON.parse(xmlhttp.responseText))
        }
    };
    xmlhttp.open("GET", url, true);
    // xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send();
}

function ajax_delete(url, successCallback, failCallback) {
    let xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            successCallback(JSON.parse(xmlhttp.responseText))
        }
    };
    xmlhttp.open("DELETE", url, true);
    // xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send();
}

// string format
String.prototype.format = function () {
    if (arguments.length === 0) {
        return this;
    }
    for (var StringFormat_s = this, StringFormat_i = 0; StringFormat_i < arguments.length; StringFormat_i++) {
        StringFormat_s = StringFormat_s.replace(new RegExp("\\{" + StringFormat_i + "\\}", "g"), arguments[StringFormat_i]);
    }
    return StringFormat_s;
};

// 创建html元素
function createFrag(template) {
    return document.createRange().createContextualFragment(template);
}

// Toast弹窗
function Toast(msg, duration) {
    duration = isNaN(duration) ? 3000 : duration;
    let m = document.createElement('div');
    m.innerHTML = msg;
    m.style.cssText = "max-width:60%;min-width: 150px;padding:0 14px;height: 40px;color: rgb(255, 255, 255);line-height: 40px;text-align: center;border-radius: 4px;position: fixed;top: 20%;left: 50%;transform: translate(-50%, -50%);z-index: 999999;background: rgba(0, 0, 0,.7);font-size: 16px;";
    document.body.appendChild(m);
    setTimeout(function () {
        let d = 0.5;
        m.style.webkitTransition = '-webkit-transform ' + d + 's ease-in, opacity ' + d + 's ease-in';
        m.style.opacity = '0';
        setTimeout(function () {
            document.body.removeChild(m)
        }, d * 1000);
    }, duration);
}