/**
 * 
 */
package com.frac.FracAdvanced.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author ShubhamGaur
 *
 */
@Entity
@Table(name = "reservoirFluid")
public class ReservoirFluidModel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		private String param;
		private String value;
		private String fluidtype;
		private String wellType;
		public String getFluidtype() {
			return fluidtype;
		}
		public void setFluidtype(String fluidtype) {
			this.fluidtype = fluidtype;
		}
		@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
				fetch=FetchType.LAZY)
		@JoinColumn(name="pId", nullable=true)
		private ProjectDetails details;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getParam() {
			return param;
		}
		public void setParam(String param) {
			this.param = param;
		}
		@Override
		public String toString() {
			return "ReservoirFluidModel [id=" + id + ", param=" + param + ", value=" + value + ", fluidtype="
					+ fluidtype + ", wellType=" + wellType + ", details=" + details + "]";
		}
		public String getWellType() {
			return wellType;
		}
		public void setWellType(String wellType) {
			this.wellType = wellType;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public ProjectDetails getDetails() {
			return details;
		}
		public void setDetails(ProjectDetails details) {
			this.details = details;
		}
		
		
		public ReservoirFluidModel() {
			super();
		}
		public ReservoirFluidModel(Integer id, String param, String value, String fluidtype, String wellType,
				ProjectDetails details) {
			super();
			this.id = id;
			this.param = param;
			this.value = value;
			this.fluidtype = fluidtype;
			this.wellType = wellType;
			this.details = details;
		}
		
		
		
}
