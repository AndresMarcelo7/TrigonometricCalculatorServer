package edu.eci.arep.parcialArep;

import edu.eci.arep.parcialArep.services.calculatorServices;
import edu.eci.arep.parcialArep.services.calculatorServicesImpl;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.*;
public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/",(req,res)-> "Bienvenido al Servidor Lógico del parcial de arep :D");
        post("/results", (req, res) -> {return results(req, res);});
    }
    private static JSONObject results(Request req, Response res) {
        calculatorServices calc = new calculatorServicesImpl();
        String[] params = req.body().split(",");
        String func = params[1];
        JSONObject jsObject = new JSONObject();
        try {
            double num = Double.parseDouble(params[0]);
            switch (func) {
                case "sin":
                    jsObject.put("Result", calc.calculateSin(num));
                    break;
                case "cos":
                    jsObject.put("Result", calc.calculateCos(num));
                    break;
                case "tan":
                    jsObject.put("Result", calc.calculateTan(num));
                    break;
                default:
                    jsObject.put("Result", "ERROR");
                    break;
            }
        }
        catch(Exception e){
            jsObject.put("Result", "ERROR");
        }
        return jsObject;
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e on localhost)
    }

}