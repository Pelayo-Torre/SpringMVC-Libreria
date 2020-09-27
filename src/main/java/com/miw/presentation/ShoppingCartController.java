package com.miw.presentation;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.business.bookmanager.BookManagerService;
import com.miw.model.Book;
import com.miw.model.ShoppingCart;

@Controller
public class ShoppingCartController {

	@Autowired
	private BookManagerService bookManagerService;
	
	@Autowired 
	private HttpSession session;

	@RequestMapping("private/shoppingCart/show")
	public String showShopppingCart(Model model) {
		model.addAttribute("shoppingcart", session.getAttribute("shoppingcart"));
		return "private/showShoppingCart";
	}
	
	@RequestMapping("private/shoppingCart/showForm")
	public String showFormShopppingCart(Model model) throws Exception {
		model.addAttribute("booklist", bookManagerService.getBooks());
		return "private/shoppingCart";
	}
	
	@RequestMapping(value="private/shoppingCart/addCart", method = RequestMethod.POST)
	public String addCart(@ModelAttribute("booksSelected") ShowBooksSelected books) throws Exception {
		ShoppingCart sc = (ShoppingCart) session.getAttribute("shoppingcart");
		
		if ( sc == null )
		{
			sc = new ShoppingCart();
			session.setAttribute("shoppingcart", sc);
		}
		
		for(Integer id : books.getSeleccionados()) {
			String name = getNameOfBookByIdentifier(id);
			if(name != null)
				sc.add(name);
		}
		
		return "redirect:/private/shoppingCart/show";
	}
	
	private String getNameOfBookByIdentifier(Integer id) throws Exception {
		for(Book b : bookManagerService.getBooks()) {
			if(b.getId() == (id))
				return b.getTitle();
		}
		return null;
	}
	
	@ModelAttribute("booksSelected")
	public ShowBooksSelected getBooksSelected() {
		return new ShowBooksSelected();
	}

	public void setBookManagerService(BookManagerService bookManagerService) {
		this.bookManagerService = bookManagerService;
	}
	
	private class ShowBooksSelected{
	
		private Integer [] seleccionados;
		
		public Integer[] getSeleccionados() {
			return seleccionados;
		}
		
		@SuppressWarnings("unused")
		public void setSeleccionados(Integer[] seleccionados) {
			this.seleccionados = seleccionados;
		}

	}
		
}
