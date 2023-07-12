use Quanlybanhang;
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oID,oDate,oTotalPrice from oder;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select customer.cName, product.pName, oder.oDate , orderdetail.odqty from customer
join oder on  oder.cID  = customer.cID 
join orderdetail on orderdetail.oID = oder.oID
join product on product.pID = orderdetail.pID;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select customer.cName, oder.cID from customer
left join oder on oder.cID = customer.cID
where oder.oID is null;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)
select oder.oID, oder.odate, sum(orderdetail.odQTY*product.pPrice) as oTotalPrice from oder
join orderdetail on orderdetail.oID = oder.oID
join product on product.pID = orderdetail.pID
group by oder.oID; 