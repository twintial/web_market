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

function ajax_post(url, data, successCallback, failCallback) {
    let xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState===4 && xmlhttp.status===200){
            successCallback(JSON.parse(xmlhttp.responseText))
        }
    };
    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(data);
}

function ajax_get(url, successCallback, failCallback) {
    let xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState===4 && xmlhttp.status===200){
            successCallback(JSON.parse(xmlhttp.responseText))
        }
    };
    xmlhttp.open("GET", url, true);
    // xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send();
}