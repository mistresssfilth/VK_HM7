package servlets;

import com.google.gson.Gson;
import dao.CompanyDAO;
import dao.ProductDAO;
import entity.Company;
import generated.tables.records.ProductRecord;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet {
    private final CompanyDAO companyDAO = new CompanyDAO();
    private final ProductDAO productDAO = new ProductDAO();

    @Override
    public void init() throws ServletException {
        super.init();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("name");
        String companyName = req.getParameter("companyName");
        int amount = Integer.parseInt(req.getParameter("amount"));

        Company company = companyDAO.getByName(companyName);
        if (company == null){
            companyDAO.save(new Company(companyName));
            company = companyDAO.getByName(companyName);
        }
        productDAO.save(new ProductRecord()
                .setName(productName)
                .setCompanyName(company.getName())
                .setAmount(amount)
        );

        resp.getWriter().println("Product " + productName + " has been added");
        resp.setStatus(HttpServletResponse.SC_OK);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson =  new Gson();
        resp.setContentType("text/plain");
        resp.getWriter().println(gson.toJson(productDAO.getAll()));
    }

}
