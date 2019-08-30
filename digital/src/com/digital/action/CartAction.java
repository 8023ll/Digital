package com.digital.action;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.digital.entity.CartItemBean;
import com.digital.entity.ProductInfo;
import com.digital.entity.UserInfo;
import com.digital.service.ProductInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware {
	private Integer productInfoId;
	int quantity;
	public Integer getProductInfoId() {
		return productInfoId;
	}
	public void setProductInfoId(Integer productInfoId) {
		this.productInfoId = productInfoId;
	}
	public int getQuantity() {
		return quantity;
	} 
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	ProductInfoService productInfoService;
	public void setProductInfoService(ProductInfoService productInfoService) {
			this.productInfoService = productInfoService;
	}
	
	Map<String,Object> session;
	@Override
    public void setSession(Map<String, Object> session) {
		this.session=session;
	}

    public String addtoshopcart() throws Exception {
    	Map cart=(Map)session.get("cart");
    	ProductInfo productInfo=productInfoService.getProductInfoByPiId(productInfoId);
    		if(cart==null) {
    		cart=new HashMap();
    		session.put( "cart",cart);
    		}
    	
    	//如果存在购物车，则判断商品是否在购物车中
     	CartItemBean cartItem = (CartItemBean)cart.get(productInfo.getId());
     	if(cartItem!=null){
     		//如果商品在购物车中， 更新其数量
     		cartItem.setQuantity(cartItem.getQuantity( )+1);
 		}else{
 			//否则，创建一个条目到Map中
 			cart.put(productInfo.getId(),new CartItemBean(productInfo,1));

 		}
     	return "shopCart"; //页面转到cart.jsp,显示购物车
     }	
    
    public String updateSelectedQuantity() {
    	//从session中取出购物车放入map对象cart中
    	Map cart=(Map)session.get("cart");
    	CartItemBean cartItem=(CartItemBean) cart.get(productInfoId);
    	cartItem.setQuantity(quantity);
    	return "shopCart";
    }
    
    public String deleteSelectedOrders() throws Exception {

        //从session中取出鈎物牟，放入Map対象cart中
    	Map cart=(Map)session.get("cart");
    	cart.remove( productInfoId);
    	return "shopCart";
    	}
    
   //清空胸物牟
    public String clearCart() throws Exception {
    //从session中取出胸物牟，放入Map対象cart中
    	Map cart=(Map)session.get("cart");
    	cart.clear();
    	return "shopCart";

    }

    
}