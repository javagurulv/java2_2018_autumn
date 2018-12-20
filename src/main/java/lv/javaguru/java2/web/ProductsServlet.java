package lv.javaguru.java2.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.java2.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//EXAMPLE
public class ProductsServlet extends HttpServlet {

    private List<Product> products = new ArrayList<>(); //will be removed after DI
    private ObjectMapper mapper = new ObjectMapper(); //will be removed after DI

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println(mapper.writeValueAsString(products));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Product product = mapper.readValue(reader, Product.class);
        products.add(product);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }
}
