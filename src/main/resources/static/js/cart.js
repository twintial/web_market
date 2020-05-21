class Item {
    constructor(goodsId, count, price) {
        this.goodsId = goodsId;
        this.goodsCount = count;
        this.price = price;
    }
}

var checkout_list = [];
var total_cost = 0;

function index_of_item(goodsId) {
    for (let i = 0; i < checkout_list.length; i++) {
        if (checkout_list[i].goodsId === goodsId) {
            return i;
        }
    }
    return -1;
}

// 获得购物车列表
function get_cart_list(page, size) {
    let uId = sessionStorage.getItem("id");
    console.log(uId);
    if (uId === "null") {
        alert("请先登陆");
        window.location.href = "/login";
        return;
    }
    let success_callback = function (response) {
        console.log(response);
        let data = response.data.list;
        let cart_body = document.getElementById("cart-body");
        for (let i = 0; i < data.length; i++) {
            let tr = document.createElement("tr");
            tr.setAttribute("id", data[i].cartId);
            let td_class = ["product-remove", "product-thumbnail", "product-name", "product-price", "product-quantity", "", ""];
            let td_children = [
                createFrag('<a title="从购物车中删除" onclick="remove(this)">×</a>'),
                createFrag('<a href="/single?goodsId={0}"><img width="145" height="145" alt="picture"'.format(data[i].goodsId) +
                    ' src="../img/goods/{0}"></a>'.format("pic6.jpg")),
                createFrag('<a href="/single?goodsId={0}">{0}</a>'.format(data[i].goodsId).format(data[i].goodsName)),
                createFrag('<span class="amount">¥{0}</span>'.format(data[i].price)),
                createFrag('                    <div class="quantity">\n' +
                    '                        <input type="button" name={0} class="minus" onclick="plus(this, -1)" value="-">\n'.format(data[i].goodsId) +
                    '                        <input type="number" size="4" title="数量" value="1" min="1" step="1">\n' +
                    '                        <input type="button" name={0} class="plus" onclick="plus(this, 1)" value="+">\n'.format(data[i].goodsId) +
                    '                    </div>'),
                createFrag('<span class="amount">¥{0}</span>'.format(data[i].price)),
                createFrag('<input type="checkbox" onclick="check(this)" id={0}>'.format(data[i].goodsId))];
            for (let j = 0; j < 7; j++) {
                let td = document.createElement("td");
                td.setAttribute("class", td_class[j]);
                td.appendChild(td_children[j]);
                tr.appendChild(td);
            }
            cart_body.appendChild(tr);
        }

    };
    let fail_callback = function () {
        alert("商品获取失败")
    };
    let shop_car = {"userId": uId};
    ajax_post("/shopCar/goodsInfo/" + page + "/" + size, JSON.stringify(shop_car), success_callback, fail_callback)
}

function plus(button, n) {
    let num = button.parentNode.children[1];
    let temp = Number(num.value) + n;
    let total = button.parentNode.parentNode.nextSibling.childNodes[0];
    let price = button.parentNode.parentNode.previousSibling.childNodes[0];
    let goodsId = button.name;
    if (temp > 0) {
        num.value = temp;
        total.innerHTML = '¥{0}'.format(price.innerHTML.replace('¥', '') * temp);
        let index = index_of_item(goodsId);
        if (index !== -1) {
            checkout_list[index].goodsCount += n;
        }
    }
}

// 删除
function remove(button) {
    let d = button.parentNode.parentNode;
    let success = function (response) {
        fadeout(d, 0, 20, 50);
        Toast("删除成功", 1000);
    };

    ajax_delete('/shopCar/{0}'.format(d.id), success, null);
}

function check(checkbox) {
    // console.log(checkbox.checked);
    // console.log(checkbox.id);
    let goodsId = checkbox.id;
    let node = checkbox.parentNode.previousSibling;
    let price = node.firstChild.textContent.replace("¥", "");
    let num = Number(node.previousSibling.childNodes[1].childNodes[3].value);
    // console.log(price);
    // console.log(num);
    let index = index_of_item(goodsId);
    if (checkbox.checked === true) {
        if (index !== -1) {
            checkout_list[index].goodsCount += num;
        } else {
            checkout_list.push(new Item(goodsId, num, price))
        }
    } else {
        console.log(index);
        checkout_list[index].goodsCount -= num;
    }
    console.log(checkout_list);
}

// 结算
function checkout() {
    // 去掉count为0的item
    checkout_list = checkout_list.filter(function(item){
        total_cost += item.price * item.goodsCount;
        return item.goodsCount !== 0;
    });

    let success = function (response) {
        total_cost = 0;
        if (response.code === 200) {
            alert("购买成功");
            window.location.href = '/cart';
        }
    };
    let l = {"checkoutList": checkout_list};
    ajax_post('/order/create/{0}'.format(total_cost), JSON.stringify(l), success, null);
}

function fadeout(ele, opacity, count, speed) {
    if (ele) {
        var v = ele.style.filter.replace("alpha(opacity=", "").replace(")", "") || ele.style.opacity || 100;
        v < 1 && (v = v * 1000);
        var avg = (100 - opacity) / count;
        var timer = null;
        timer = setInterval(function () {
            if (v - avg > opacity) {
                v -= avg;
                setOpacity(ele, v);
            } else {
                clearInterval(timer);
                ele.remove();
            }
        }, speed);
    }
}

function setOpacity(ele, opacity) {
    if (ele.style.opacity !== undefined) {
        ele.style.opacity = opacity / 100;
    }
}