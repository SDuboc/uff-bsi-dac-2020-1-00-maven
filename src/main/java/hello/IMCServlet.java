package hello;

import imc.IMC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/imc")
public class IMCServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        Float peso = trataInput(request.getParameter("peso"));
        Float altura = trataInput(request.getParameter("altura"));

        Float imc = IMC.calculaIMC(peso, altura);
        System.out.println("IMC: " + imc);
        String classificacaoIMC = IMC.classificaIMC(imc);

        String msg = "Olá, " + nome + "!<p>O seu IMC é " + String.format("%.02f", imc) + ".<p>A classificação para o seu IMC é: <b>" + classificacaoIMC + "<b>";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IMCServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private Float trataInput(String input) {
        input = input.replace(",", ".");
        String regex = "(\\d{1,3}.?\\d{0,2})";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while (m.find()) {
            return Float.parseFloat(m.group());
        }
        return null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IMCServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
