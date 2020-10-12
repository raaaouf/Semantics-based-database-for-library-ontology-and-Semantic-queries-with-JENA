package jena_Exam_parql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class Library_Sparql_ExamenRaouf2020 {
	 public static void main(String[] args) {
		   Model model= ModelFactory.createDefaultModel();
		   
		   String fileName = "C:\\Users\\raouf\\Documents\\master1 sid TP\\s1\\ws\\jena_tuto_raouf2019\\library.owl";

	       InputStream file;
		try {
			file = new FileInputStream(fileName);
			model.read(file, "RDF/XML");
	        /*Liste des livres disponibles dans la bibliothèque selon leur format  et leurs auteurs et tout les format disponible */


	    	String queryString4 =  "PREFIX ns:<http://www.semanticweb.org/Semantic_Degital_Library_system-ontology#> \n" + 
	    	    	"PREFIX rdfs:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
	    	    	"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+		
	    	                "SELECT Distinct ?book ?titre ?Auteur ?autre_format  WHERE{ \n" +
	    	             
	    	                "VALUES ?b {ns:EBook ns:Book ns:AudioDocument ns:MultivolumeBook} ?book a ?b ."+
	    	                "?book ns:Title ?titre ."+
	    	    			"?book ns:Author ?Auteur ."+
	    	    			"?book ns:Bookformat ?autre_format ."+
	    	    			
	    	                
	    	                
	    	                
	    	                "}";
		
			
	    	
	    	
	    	
	        System.out.println("Liste des livres disponibles  dans la bibliothèque et le format disponible, filtrage selon le format demende ");
		  	 
		  	   
		         Query query4=QueryFactory.create(queryString4);
		         QueryExecution qexec4= QueryExecutionFactory.create(query4, model);
		         ResultSet results4 = qexec4.execSelect();
		         ResultSetFormatter.out(System.out, results4, query4);
		         
		         /*Liste des livres demender par raouf zoghbi avec l'auteur Robert Johnson  filterer ebook*/


			    	String queryString5 =  "PREFIX ns:<http://www.semanticweb.org/Semantic_Degital_Library_system-ontology#> \n" + 
			    	    	"PREFIX rdfs:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
			    	    	"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+		
			    	                "SELECT  Distinct ?titre ?Auteur ?name  WHERE{ \n" +
			    	                "?book a ?p.  FILTER (?p IN (ns:EBook  ) ) "+
			    	                
			    	                "?membre a ns:Membre. "+

			    	                "?membre  ns:name 'Raouf Zoghbi'. "+
					                 "?membre ns:name ?name .\n"+

			    	                "?book ns:Title ?titre ."+

			    	    			"?book ns:Author ?Auteur ."+

			    	    			
			    	                
			    	                
			    	                
			    	                "}";
				
					
			    	
			    	
			    	
			        System.out.println("Liste des livres demender par raouf zoghbi filtrer par le format EBOOK  de l'auteur Robert Johnson ");
				  	 
				  	   
				         Query query5=QueryFactory.create(queryString5);
				         QueryExecution qexec5= QueryExecutionFactory.create(query5, model);
				         ResultSet results5 = qexec5.execSelect();
				         ResultSetFormatter.out(System.out, results5, query5);
				         
				         
				     	//Donner le nom  d'un membre et voir  sa date de fin de subscribtion et le type de subscribtion  
				     	
				     	String queryString1 =  "PREFIX ns:<http://www.semanticweb.org/Semantic_Degital_Library_system-ontology#> \n" + 
				    	    	"PREFIX rdfs:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
				    	    	"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+			
				                 "SELECT  Distinct ?name ?dateFin ?TypeSubscribtion WHERE{ \n" +

				                 "?name ns:end_of_subscribtion ?dateFin .\n"+
				     			"?name ns:Subscribtion ?TypeSubscribtion .\n"+
				                 "?name ns:name 'Raouf Zoghbi' .\n"+

				                 "}";
				                 
				                 
				 	
				     	
				        System.out.println("Donner le nom  d'un membre et voir  sa date de fin de subscribtion et le type de subscribtion  ");

				 	 Query query=QueryFactory.create(queryString1);
				      QueryExecution qexec= QueryExecutionFactory.create(query, model);
				      ResultSet results = qexec.execSelect();
				      ResultSetFormatter.out(System.out, results, query);
				      
				  	//Donner le titre et la date et list des guests   d'un evenemnt de Robert Johnson  
				     	
				     	String queryString0 =  "PREFIX ns:<http://www.semanticweb.org/Semantic_Degital_Library_system-ontology#> \n" + 
				    	    	"PREFIX rdfs:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
				    	    	"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+			
				                 "SELECT  Distinct ?Guests ?titre  ?date WHERE{ \n" +			
				    	    	"?membre ns:name ?Guests  .\n"+	
				                 "?events ns:Title ?titre .\n"+
				    	    	
				                 "?membre ns:Participate ?events .\n"+
				                  
				                 "?events ns:Tutor 'Robert Johnson' .\n"+
				                 "?events ns:Date ?date .\n"+

				                 "}";
				                 
				                 
				 	
				     	
				        System.out.println("Donner le titre et la date et list des guests   d'un evenemnt de Robert Johnson  ");

				 	 Query query0=QueryFactory.create(queryString0);
				      QueryExecution qexec0= QueryExecutionFactory.create(query0, model);
				      ResultSet results0 = qexec0.execSelect();
				      ResultSetFormatter.out(System.out, results0, query0);
				      
				      
				  	
				     	String queryStringh =  "PREFIX ns:<http://www.semanticweb.org/Semantic_Degital_Library_system-ontology#> \n" + 
				    	    	"PREFIX rdfs:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
				    	    	"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+			
				                 "SELECT   Distinct ?title (COUNT(?title) as ?nombre_of_vue) WHERE{ \n" +
					     			"?name ns:Enroll ?video .\n"+
				                 "?video ns:Title ?title .\n"+

				                 "}"+" group by  ?title \n";
				     	 
				         System.out.println("Donner les video ou cours  et le nombre de vue");

					 	 Query queryh=QueryFactory.create(queryStringh);
					      QueryExecution qexech= QueryExecutionFactory.create(queryh, model);
					      ResultSet resultsh = qexech.execSelect();
					      ResultSetFormatter.out(System.out, resultsh, queryh);
					      
		        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	    }

}
