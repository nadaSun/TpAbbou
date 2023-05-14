package ma.ecommerce.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.ecommerce.service.model.Role;



public class RoleConverter {
	public static RoleDTO toVo(Role bo) {
		if (bo == null)
			return null;
		RoleDTO vo = new RoleDTO();
		vo.setId(bo.getId());
		vo.setRole(bo.getRole());
		return vo;
	}

	public static Role toBo(RoleDTO vo) {
		if (vo == null)
			return null;
		Role bo = new Role();
		bo.setId(vo.getId());
		bo.setRole(vo.getRole());
		return bo;
	}

	public static List<RoleDTO> toVoList(List<Role> boList) {
		if (boList == null || boList.isEmpty())
			return null;
		List<RoleDTO> voList = new ArrayList<>();
		for (Role role : boList) {
			voList.add(toVo(role));
		}
		return voList;
	}
	
	public static List<Role> toBoList(List<RoleDTO> voList) {
		if (voList == null || voList.isEmpty())
		return null;
		List<Role> boList = new ArrayList<>();
		for (RoleDTO roleVo : voList) {
		boList.add(toBo(roleVo));
		}
		return boList; } }
