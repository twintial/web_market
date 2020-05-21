function get_goods(page, size) {
    let success_callback = function (response) {
        console.log(response);
        let card_container = document.getElementById("goods-list");
        // while (card_container.hasChildNodes()) {
        //     card_container.removeChild(card_container.firstChild);
        // }
        let good_list = response.data.list;
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
            img.setAttribute("alt", "picture");

            let price = document.createElement("a");
            price.setAttribute("class", "goods-price");
            price.innerHTML = "¥ " + good_list[i].price;

            let name = document.createElement("a");
            name.setAttribute("class", "goods-name");
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
    };
    let fail_callback = function () {
        alert("商品获取失败")
    };
    ajax_get("/goods/search/" + page + "/" + size, success_callback, fail_callback)
}

function add_to_cart(button) {
    let goodsId = button.parentNode.id;
    let uId = sessionStorage.getItem("id");
    if (uId === "null") {
        Toast("请先登陆", 1000);
        return;
    }
    let shopCar = {"userId": uId, "goodsId": goodsId, "count": 1};
    let successCallback = function (response) {
        if (response.code === 200) {
            Toast("添加成功", 1000);
        }
    };
    ajax_post("/shopCar", JSON.stringify(shopCar), successCallback, null);
}