package fr.yohan.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.BeanUtils;

import fr.yohan.dto.CentreMedicalDTO;
import fr.yohan.dto.InfirmierDTO;
import fr.yohan.dto.MedecinDTO;
import fr.yohan.dto.PharmacieDTO;
import fr.yohan.entity.CentreMedical;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Infirmier;
import fr.yohan.entity.Medecin;
import fr.yohan.entity.Pharmacie;
import fr.yohan.facade.Facade;

@Path("/search")
public class searchNearbyProWSRest {

	@GET
	@Path("/all/{latitude}/{longitude}/{distance}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> getProsNearby(@PathParam("latitude") double latitude,
			@PathParam("longitude") double longitude, @PathParam("distance") int distance) {
		GPSLoc loc = new GPSLoc(latitude, longitude);
		Map<String, Object> prosOnline = new HashMap<>();
		List<MedecinDTO> medecins = getMedecinsAround(loc, distance);
		List<PharmacieDTO> pharmacies = getPharmaciesAround(loc, distance);
		List<CentreMedicalDTO> centreMedicaux = getCentreMedicauxAround(loc, distance);
		List<InfirmierDTO> infirmiers = getInfirmiersAround(loc, distance);
		prosOnline.put("medecins", medecins);
		prosOnline.put("pharmacies", pharmacies);
		prosOnline.put("centreMedicaux", centreMedicaux);
		prosOnline.put("infirmiers", infirmiers);
		return prosOnline;
	}

	@GET
	@Path("/medecins/{latitude}/{longitude}/{distance}")
	@Produces(MediaType.APPLICATION_JSON)
	//Access-Control-Allow-Origin:
	public Response getMedecinsNearby(@PathParam("latitude") double latitude,
			@PathParam("longitude") double longitude, @PathParam("distance") int distance) {
		
		GPSLoc loc = new GPSLoc(latitude, longitude);
		
		Map<String, Object> result = new HashMap<>();

		
		
		List<MedecinDTO> medecins = getMedecinsAround(loc, distance);
		result.put("medecins", medecins);
		
		
		 Response response = Response.status(200).
	                entity(result).
	                header("Access-Control-Allow-Origin", "*").build();

	        return response;
		
		
		//return medecins;
	}

	@GET
	@Path("/pharmacies/{latitude}/{longitude}/{distance}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PharmacieDTO> getPharmaciesNearby(@PathParam("latitude") double latitude,
			@PathParam("longitude") double longitude, @PathParam("distance") int distance) {
		GPSLoc loc = new GPSLoc(latitude, longitude);
		List<PharmacieDTO> pharmacies = getPharmaciesAround(loc, distance);
		return pharmacies;
	}

	@GET
	@Path("/centreMedicaux/{latitude}/{longitude}/{distance}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CentreMedicalDTO> getcentreMedicauxNearby(@PathParam("latitude") double latitude,
			@PathParam("longitude") double longitude, @PathParam("distance") int distance) {
		GPSLoc loc = new GPSLoc(latitude, longitude);
		List<CentreMedicalDTO> centreMedicaux = getCentreMedicauxAround(loc, distance);
		return centreMedicaux;
	}

	@GET
	@Path("/infirmiers/{latitude}/{longitude}/{distance}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<InfirmierDTO> getInfirmiersNearby(@PathParam("latitude") double latitude,
			@PathParam("longitude") double longitude, @PathParam("distance") int distance) {
		GPSLoc loc = new GPSLoc(latitude, longitude);
		List<InfirmierDTO> infirmiers = getInfirmiersAround(loc, distance);
		return infirmiers;
	}

	public List<MedecinDTO> getMedecinsAround(GPSLoc loc, int distance) {
		List<Medecin> medecins = Facade.getInstance().getMedecinService().getMedecinsByLoc(loc, distance);
		List<MedecinDTO> medecinDTOs = new ArrayList<>();
		for (Medecin medecin : medecins) {
			MedecinDTO target = new MedecinDTO();
			BeanUtils.copyProperties(medecin, target);
			medecinDTOs.add(target);
		}
		return medecinDTOs;
	}
	public List<PharmacieDTO> getPharmaciesAround(GPSLoc loc, int distance) {
		List<Pharmacie> pharmacies = Facade.getInstance().getPharmacieService().getPharmacieByLoc(loc, distance);
		List<PharmacieDTO> pharmacieDTOs = new ArrayList<>();
		for (Pharmacie pharmacie : pharmacies) {
			PharmacieDTO target = new PharmacieDTO();
			BeanUtils.copyProperties(pharmacie, target);
			pharmacieDTOs.add(target);
		}
		return pharmacieDTOs;
	}

	public List<CentreMedicalDTO> getCentreMedicauxAround(GPSLoc loc, int distance) {
		List<CentreMedical> centreMedicaux = Facade.getInstance().getCentreMedicalService().getCentreMedicalByLoc(loc,
				distance);
		List<CentreMedicalDTO> centreMedicalDTOs = new ArrayList<>();
		for (CentreMedical centreMedical : centreMedicaux) {
			CentreMedicalDTO target = new CentreMedicalDTO();
			BeanUtils.copyProperties(centreMedical, target);
			centreMedicalDTOs.add(target);
		}
		return centreMedicalDTOs;
	}

	public List<InfirmierDTO> getInfirmiersAround(GPSLoc loc, int distance) {
		List<Infirmier> infirmiers = Facade.getInstance().getInfirmierService().getInfirmierByLoc(loc, distance);
		List<InfirmierDTO> infirmierDTOs = new ArrayList<>();
		for (Infirmier infirmier : infirmiers) {
			InfirmierDTO target = new InfirmierDTO();
			BeanUtils.copyProperties(infirmier, target);
			infirmierDTOs.add(target);
		}
		return infirmierDTOs;
	}

}
