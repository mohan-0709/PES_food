package com.pes_food.service;

import java.util.List;

import com.pes_food.exception.CategoryException;
import com.pes_food.exception.ItemException;
import com.pes_food.exception.LoginException;
import com.pes_food.model.CategoryDTO;
import com.pes_food.model.Item;
import com.pes_food.model.ItemDTO;

public interface ItemService {

	public Item addItem(String key, Item item) throws ItemException, CategoryException, LoginException;

	public Item updateItem(String key, ItemDTO itemDTO) throws ItemException, CategoryException, LoginException;

	public Item removeItem(String key, ItemDTO itemDTO) throws ItemException, LoginException;

	public Item removeItemById(String key, Integer itemId) throws ItemException, LoginException;

	public List<Item> getAllItem(String key) throws ItemException, LoginException;

	public List<Item> getAllItemByCategory(String key, CategoryDTO categoryDTO)
			throws ItemException, CategoryException, LoginException;

	public List<Item> getAllItemByCategoryName(String key, String categoryName)
			throws ItemException, CategoryException, LoginException;

}
