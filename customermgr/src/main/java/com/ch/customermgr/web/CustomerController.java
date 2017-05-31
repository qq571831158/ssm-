package com.ch.customermgr.web;

import com.ch.customermgr.model.CustomerModel;
import com.ch.customermgr.model.CustomerQueryModel;
import com.ch.customermgr.service.ICustomerService;
import com.ch.pageutil.Page;
import com.ch.utils.format.DateFormatHelper;
import com.ch.utils.json.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by apple on 2017/5/28.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;


    @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
    public String toAdd(){
        return "customer/add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String Add(@ModelAttribute("customerModel") CustomerModel customerModel){
        customerModel.setRegisterTime(DateFormatHelper.date2str(System.currentTimeMillis()));
        customerService.create(customerModel);
        return "customer/success";
    }

    @RequestMapping(value = "/toUpdate/{customerUuid}",method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("customerUuid") int customerUuid){
        CustomerModel cm = customerService.getByUuid(customerUuid);
        model.addAttribute("cm",cm);
        return "customer/update";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@ModelAttribute("customerModel") CustomerModel customerModel){
        customerService.update(customerModel);
        return "customer/success";
    }



    @RequestMapping(value = "/toDelete/{customerUuid}",method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("customerUuid") int customerUuid){
        CustomerModel cm = customerService.getByUuid(customerUuid);
        model.addAttribute("cm",cm);
        return "customer/delete";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("uuid") int customerUuid){
        customerService.delete(customerUuid);
        return "customer/success";
    }


    @RequestMapping(value = "/toList",method = RequestMethod.GET)
    public String toList(@ModelAttribute("wm")CustomerWebModel wm,Model model){
        System.out.println("wm"+wm);
        CustomerQueryModel cqm = null;
        if (wm.getQueryJsonStr()==null||wm.getQueryJsonStr().trim().length()==0){
            cqm = new CustomerQueryModel();
        }else {
            cqm = (CustomerQueryModel) JsonHelper.str2object(wm.getQueryJsonStr(),CustomerQueryModel.class);
        }
        cqm.getPage().setNowPage(wm.getNowPage());
        if (wm.getPageShow() > 0){
            cqm.getPage().setPageShow(wm.getPageShow());
        }
        Page dbPage = customerService.getByConditionPage(cqm);
        model.addAttribute("wm",wm);
        model.addAttribute("page",dbPage);
        return "customer/list";
    }

    @RequestMapping(value = "toQuery",method = RequestMethod.GET)
    public String toQuery(){
        return "customer/query";
    }

}
