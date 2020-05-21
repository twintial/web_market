function get_goods(page, size) {
    let success_callback = function (response) {
        console.log(response);
        // while (card_container.hasChildNodes()) {
        //     card_container.removeChild(card_container.firstChild);
        // }
        let good_list = response.data.list;
        create_goods(good_list);
    };
    let fail_callback = function () {
        alert("商品获取失败")
    };
    ajax_get("/goods/search/" + page + "/" + size, success_callback, fail_callback)
}

function search(page, size) {
    let value = document.getElementById('search-value').value;
    if (value === '搜索...') {
        return;
    }
    let success_callback = function (response) {
        console.log(response);
        let card_container = document.getElementById("goods-list");
        while (card_container.hasChildNodes()) {
            card_container.removeChild(card_container.firstChild);
        }
        let good_list = response.data.list;
        create_goods(good_list);
    };
    let fail_callback = function () {
        alert("商品搜索失败")
    };
    ajax_post("/goods/search/" + page + "/" + size, JSON.stringify({'goodsName': value}), success_callback, fail_callback)
}

function create_goods(good_list) {
    let card_container = document.getElementById("goods-list");
    for (let i = 0; i < good_list.length; i++) {
        console.log(good_list[i]);
        let row33 = document.createElement("div");
        row33.setAttribute("class", "row-33");

        let card = document.createElement("div");
        card.setAttribute("class", "card");
        card.setAttribute("id", good_list[i].goodsId);
        row33.appendChild(card);

        let img = document.createElement("img");
        img.setAttribute("class", "goods-img");
        // 测试
        // img.setAttribute("src", good_list[i].img);
        img.setAttribute("src", "../img/goods/pic6.jpg");
        img.setAttribute("onclick", "jump({0})".format(good_list[i].goodsId));
        img.setAttribute("alt", "picture");

        let price = document.createElement("a");
        price.setAttribute("class", "goods-price");
        price.setAttribute("href", "/single?goodsId={0}".format(good_list[i].goodsId));
        price.innerHTML = "¥ " + good_list[i].price;

        let name = document.createElement("a");
        name.setAttribute("class", "goods-name");
        name.setAttribute("href", "/single?goodsId={0}".format(good_list[i].goodsId));
        name.innerHTML = good_list[i].goodsName;

        let button = document.createElement("a");
        button.setAttribute("class", "add_to_cart_button");
        button.setAttribute("onclick", "add_to_cart(this)");
        // button.addEventListener("onclick", add_to_cart);
        button.innerHTML = "加入购物车";

        card.appendChild(img);
        card.appendChild(price);
        card.appendChild(name);
        card.appendChild(button);

        card_container.appendChild(row33)
    }
}