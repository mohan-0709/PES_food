package com.pes_food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pes_food.exception.CategoryException;
import com.pes_food.exception.ItemException;
import com.pes_food.exception.LoginException;
import com.pes_food.model.CategoryDTO;
import com.pes_food.model.Item;
import com.pes_food.model.ItemDTO;
import com.pes_food.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	public ResponseEntity<List<Item>> getAllItem(@RequestParam(required = false) String key)
			throws ItemException, LoginException {
		List<Item> itemList = itemService.getAllItem(key);
		return new ResponseEntity<List<Item>>(itemList, HttpStatus.OK);
	}

	public ResponseEntity<List<Item>> getAllItemByCategory(@RequestParam(required = false) String key,
			@RequestBody CategoryDTO categoryDTO) throws ItemException, CategoryException, LoginException {
		List<Item> itemList = itemService.getAllItemByCategory(key, categoryDTO);
		return new ResponseEntity<List<Item>>(itemList, HttpStatus.OK);
	}

	@GetMapping("/get/{categoryName}")
	public ResponseEntity<List<Item>> getAllItemByCategoryName(@RequestParam(required = false) String key,
			@PathVariable String categoryName) throws ItemException, CategoryException, LoginException {
		List<Item> itemList = itemService.getAllItemByCategoryName(key, categoryName);
		return new ResponseEntity<List<Item>>(itemList, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Item> addItem(@RequestParam(required = false) String key, @RequestBody Item item)
			throws ItemException, CategoryException, LoginException {
		Item savedItem = itemService.addItem(key, item);

		return new ResponseEntity<Item>(savedItem, HttpStatus.CREATED);
	}

	public ResponseEntity<Item> updateItem(@RequestParam(required = false) String key, @RequestBody ItemDTO itemDTO)
			throws ItemException, CategoryException, LoginException {
		Item updatedItem = itemService.updateItem(key, itemDTO);

		return new ResponseEntity<Item>(updatedItem, HttpStatus.ACCEPTED);
	}


	public ResponseEntity<Item> removeItem(@RequestParam(required = false) String key, @RequestBody ItemDTO itemDTO)
			throws ItemException, LoginException {
		Item deletedItem = itemService.removeItem(key, itemDTO);

		return new ResponseEntity<Item>(deletedItem, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Item> removeItemById(@RequestParam(required = false) String key,
			@PathVariable("id") Integer id) throws ItemException, LoginException {
		Item deletedItem = itemService.removeItemById(key, id);

		return new ResponseEntity<Item>(deletedItem, HttpStatus.OK);
	}
}
