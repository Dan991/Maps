package model;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.json.*;
public class Http {
	private double lat;
	private double log;
	public Http() {
		
	}
	
	public Risultati rispostaDestinazione(String d){
		Risultati r=new Risultati();
		try{		
			String destinazione=d;
			String key="AIzaSyBimGuPYygooW_qEUIDmKmq52j-8utkhuc";
			String tipo="json";
			String url ="https://maps.googleapis.com/maps/api/geocode/"+tipo+"?address="+destinazione+"&key="+key;
			System.out.println(url);
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			Thread.sleep(1000);
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in =new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
			   response.append(inputLine);
			  } 
			JSONObject myresponse = new JSONObject(response.toString());
			JSONArray jsA=myresponse.getJSONArray("results");
			for(int i=0;i<jsA.length();i++) {
				Risultato risultato=new Risultato();
				JSONObject risultatoJS=jsA.getJSONObject(i);
				JSONArray ciArray=risultatoJS.getJSONArray("address_components");
				for(int i2=0;i2<ciArray.length();i2++){
					JSONObject componenteJS=ciArray.getJSONObject(i2);
					String t[]=Arrays.copyOf(componenteJS.getJSONArray("types").toList().toArray(), componenteJS.getJSONArray("types").toList().toArray().length, String[].class);
					risultato.AggiungiComponente(new Componente_indirizzo(componenteJS.get("long_name").toString(), componenteJS.get("short_name").toString(),t));
				}
				risultato.setNome(risultatoJS.getString("formatted_address"));
				risultato.setPlaceid(risultatoJS.getString("place_id"));
				risultato.AggiungiTipo(Arrays.copyOf(risultatoJS.getJSONArray("types").toList().toArray(), risultatoJS.getJSONArray("types").toList().toArray().length, String[].class));
				JSONObject cordinateJS=risultatoJS.getJSONObject("geometry");
				risultato.setCordinate(new Cordinate(Double.parseDouble(cordinateJS.getJSONObject("location").get("lat").toString()),
						Double.parseDouble(cordinateJS.getJSONObject("location").get("lng").toString())));	
				r.AggiungiRisultato(risultato);
			}
			
			in .close();
			for(int i=0;i<r.getRisultati().size();i++)
				System.out.println(r.getRisultati().get(i).getNome());	
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return r;
	}
	
	public void Immagine(double lat,double log,int zoom,JLabel lb,String tipo){
		this.lat=lat;
		this.log=log;
		try {
			String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="
			+ this.lat
			+ ","
			+ this.log
			+ "&zoom="+zoom+"&size=612x612&scale=2&maptype="+tipo;
			String destinationFile = "map.jpg";
			URL url = new URL(imageUrl);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(destinationFile);
			byte[] b = new byte[2048];
			int length;
			while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
			}
			is.close();
			os.close();
			} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
			}
			ImageIcon imageIcon = new ImageIcon((new ImageIcon("map.jpg")).getImage().getScaledInstance(350, 375,java.awt.Image.SCALE_SMOOTH));
			lb.setIcon(imageIcon);
	}
	
	public void RImmagine(int zoom,JLabel lb,String tipo){
		try {
			String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="
			+ this.lat
			+ ","
			+ this.log
			+ "&zoom="+zoom+"&size=612x612&scale=2&maptype="+tipo;
			String destinationFile = "map.jpg";
			URL url = new URL(imageUrl);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(destinationFile);
			byte[] b = new byte[2048];
			int length;
			while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
			}
			is.close();
			os.close();
			} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
			}
			ImageIcon imageIcon = new ImageIcon((new ImageIcon("map.jpg")).getImage().getScaledInstance(350, 375,java.awt.Image.SCALE_SMOOTH));
			lb.setIcon(imageIcon);
	}
	
	public Risultati rispostaLuoghiVicini(){
		Risultati r=new Risultati();
		try{		
			String key="AIzaSyCsB_Fh7NJR3c0FXV01wPmlZOis9xiNee4";
			String tipo="json";
			String url ="https://maps.googleapis.com/maps/api/place/nearbysearch/"+tipo+"?location="+this.lat+","+this.log+"&radius=500&key="+key;
			System.out.println(url);
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in =new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
			   response.append(inputLine);
			  } 
			JSONObject myresponse = new JSONObject(response.toString());
			JSONArray jsA=myresponse.getJSONArray("results");
			for(int i=0;i<jsA.length();i++) {
				Risultato risultato=new Risultato();
				JSONObject risultatoJS=jsA.getJSONObject(i);
				risultato.setNome(risultatoJS.getString("name"));
				risultato.setPlaceid(risultatoJS.getString("place_id"));
				risultato.AggiungiTipo(Arrays.copyOf(risultatoJS.getJSONArray("types").toList().toArray(), risultatoJS.getJSONArray("types").toList().toArray().length, String[].class));
				JSONObject cordinateJS=risultatoJS.getJSONObject("geometry");
				risultato.setCordinate(new Cordinate(Double.parseDouble(cordinateJS.getJSONObject("location").get("lat").toString()),
						Double.parseDouble(cordinateJS.getJSONObject("location").get("lng").toString())));	
				risultato.setIcona(risultatoJS.getString("icon"));
				r.AggiungiRisultato(risultato);
			}
			in .close();
			for(int i=0;i<r.getRisultati().size();i++)
				System.out.println(r.getRisultati().get(i).getNome());	
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return r;
	}

	public double getLat() {
		return lat;
	}

	public double getLog() {
		return log;
	}
}
