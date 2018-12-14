package com.shanijeet.inventory.microservices.inventoryitemmicroservice.resource;

import com.shanijeet.inventory.microservices.inventoryitemmicroservice.exception.ItemAlreadyExistsException;
import com.shanijeet.inventory.microservices.inventoryitemmicroservice.exception.ItemNotFoundException;
import com.shanijeet.inventory.microservices.inventoryitemmicroservice.model.Item;
import com.shanijeet.inventory.microservices.inventoryitemmicroservice.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    @Autowired
    Environment environment;


    @RequestMapping(path = "/items", method = RequestMethod.POST)
    public void createItem(@RequestBody Item item)
    {
        if(itemService.searchItem(item.getItemid())!=null)
        {
            throw new ItemAlreadyExistsException("item ID"+item.getItemid());
        }
        itemService.createItem(item);
    }

    @RequestMapping(path = "/items/{itemid}",method = RequestMethod.GET)
    public  Item findItem(@PathVariable Long itemid)
    {
      Item item=itemService.searchItem(itemid);
      if(item==null)
      {
          throw new ItemNotFoundException("itemId" +itemid);
      }

      item.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        return item;
    }

    @RequestMapping(path = "/items",method = RequestMethod.GET)
    public List<Item> getItems()
    {
        return itemService.findallItems();
    }
}
