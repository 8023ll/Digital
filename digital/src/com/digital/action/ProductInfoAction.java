package com. digital.action;
import java.util.Map;
import com.digital.entity.*;
import java.util.List;
import org.apache.struts2.interceptor.RequestAware;
import com.digital.service.ProductInfoService;
import com.digital.service.TypeService;
import com.opensymphony.xwork2.ActionSupport;
public class ProductInfoAction extends ActionSupport implements RequestAware{
   
	 ProductInfoService productInfoService;

     public void setProductInfoService(ProductInfoService productInfoService) {
    	 this. productInfoService = productInfoService;
     }

      TypeService typeService;
      public void setTypeService(TypeService typeService) {
      this.typeService = typeService;
      }
      
      Map<String ,Object> request;

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	public String list() throws Exception{
		List<Type> typeList=typeService.getAllWithDistinctBrand();
		if(typeList.size()>0) {
			request.put("typeList", typeList);
		}
		List<ProductInfo> piList=productInfoService.getAllProductInfo();
		if(piList.size()>0) {
			request.put("piList", piList);
		}
		
	    return "index";
	}
	 
	ProductInfo pi;
	
	      //省略已实现的代码ProductInfo pi;

	      //省略pi属性的getter、setter方法//产品详情

	 public ProductInfo getPi() {
		return pi;
	}

	 public void setPi(ProductInfo pi) {
		this.pi = pi;
	 }

	 public String show() throws Exception {

	      ProductInfo detailProductInfo = productInfoService.getProductInfoByPiId(pi.getId());

	      request.put("detailProductInfo", detailProductInfo);//处理Cookies,保存浏览排行榜的信息，暂未处理，后面讲解;
	      return "show" ;
	      }
}