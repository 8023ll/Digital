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
    	
    	//������ڹ��ﳵ�����ж���Ʒ�Ƿ��ڹ��ﳵ��
     	CartItemBean cartItem = (CartItemBean)cart.get(productInfo.getId());
     	if(cartItem!=null){
     		//�����Ʒ�ڹ��ﳵ�У� ����������
     		cartItem.setQuantity(cartItem.getQuantity( )+1);
 		}else{
 			//���򣬴���һ����Ŀ��Map��
 			cart.put(productInfo.getId(),new CartItemBean(productInfo,1));

 		}
     	return "shopCart"; //ҳ��ת��cart.jsp,��ʾ���ﳵ
     }	
    
    public String updateSelectedQuantity() {
    	//��session��ȡ�����ﳵ����map����cart��
    	Map cart=(Map)session.get("cart");
    	CartItemBean cartItem=(CartItemBean) cart.get(productInfoId);
    	cartItem.setQuantity(quantity);
    	return "shopCart";
    }
    
    public String deleteSelectedOrders() throws Exception {

        //��session��ȡ���h��Ĳ������Map����cart��
    	Map cart=(Map)session.get("cart");
    	cart.remove( productInfoId);
    	return "shopCart";
    	}
    
   //�������Ĳ
    public String clearCart() throws Exception {
    //��session��ȡ������Ĳ������Map����cart��
    	Map cart=(Map)session.get("cart");
    	cart.clear();
    	return "shopCart";

    }

    
}