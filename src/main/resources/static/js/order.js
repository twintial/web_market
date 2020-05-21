// 获得订单列表
function get_order_list(page, size) {
    let uId = sessionStorage.getItem("id");
    if (uId === "null") {
        alert("请先登陆");
        window.location.href = "/login";
        return;
    }
    let success_callback = function (response) {
        let container = document.getElementById("container");
        let td_class = ["product-thumbnail", "product-name", "product-price", "product-quantity", "product-subtotal"];
        let th_text = ['', '商品名称', '价格', '数量', '总价'];
        console.log(response);
        let order_list = response.data;

        for (let i = 0; i < order_list.length; i++) {
            let thread = document.createElement('thead');
            let head_tr = document.createElement('tr');
            for (let i = 0; i < 5; i++) {
                let th = document.createElement('th');
                th.setAttribute("class", td_class[i]);
                th.innerHTML = th_text[i];
                head_tr.appendChild(th);
            }
            thread.appendChild(head_tr);
            let outer_div = document.createElement('div');
            let table = document.createElement('table');
            table.setAttribute('cellspacing', '0');
            table.setAttribute('class', 'shop_table');
            let goods_list = order_list[i].goodsList;
            let body = document.createElement('tbody');
            for (let j = 0; j < goods_list.length; j++) {
                let tr = document.createElement("tr");
                let td_children = [
                    createFrag('<a href="/single?goodsId={0}"><img width="145" height="145" alt="picture"'.format(goods_list[j].goodsId) +
                        ' src="../img/goods/{0}"></a>'.format("pic6.jpg")),
                    createFrag('<a href="/single?goodsId={0}">{0}</a>'.format(goods_list[j].goodsId).format(goods_list[j].goodsName)),
                    createFrag('<span class="amount">¥{0}</span>'.format(goods_list[j].price)),
                    createFrag('<span class="amount">{0}</span>'.format(goods_list[j].goodsCount)),
                    createFrag('<span class="amount">¥{0}</span>'.format(goods_list[j].price))];
                for (let k = 0; k < 5; k++) {
                    let td = document.createElement("td");
                    td.setAttribute("class", td_class[k]);
                    td.appendChild(td_children[k]);
                    tr.appendChild(td);
                }
                body.appendChild(tr);
            }
            table.appendChild(thread);
            table.appendChild(body);
            outer_div.appendChild(table);

            let date = new Date(order_list[i].createTime);
            let info_div = createFrag('        <div class="order-info">\n' +
                '            <p class="foot">订单号：<span class="code">{0}</span></p>\n'.format(order_list[i].orderId) +
                '            <p class="foot">创建日期：<span class="time">{0}</span></p>\n'.format(date.dateFormat("yyyy-MM-dd hh:mm:ss")) +
                '            <p class="foot">订单金额：<span class="total">¥{0}</span></p>\n'.format(order_list[i].total) +
                '        </div>')
            outer_div.appendChild(info_div);
            container.appendChild(outer_div);
        }

    };
    let fail_callback = function () {
        alert("商品获取失败")
    };
    let shop_car = {"userId": uId};
    ajax_get("/order/search/" + page + "/" + size, success_callback, fail_callback)
}