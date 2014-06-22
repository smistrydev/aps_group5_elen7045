package elen7045.group5.project.aps.billing;

/**
 * Statement information specific to Municipalities
 */
public class MunicipalityStmntBean extends StatementBean
{
	private static final long serialVersionUID = 122222L;
	private String instalmentNotice;
	private float	electricityUsed,
					electricityCharges,
					gasUsed,
					gasCharges,
					waterUsed,
					waterCharges,
					sewerageCharges,
					refuseCharges;
	
	public String getInstalmentNotice() {
		return instalmentNotice;
	}
	public void setInstalmentNotice(String instalmentNotice) {
		this.instalmentNotice = instalmentNotice;
	}
	public float getElectricityUsed() {
		return electricityUsed;
	}
	public void setElectricityUsed(float electricityUsed) {
		this.electricityUsed = electricityUsed;
	}
	public float getElectricityCharges() {
		return electricityCharges;
	}
	public void setElectricityCharges(float electricityCharges) {
		this.electricityCharges = electricityCharges;
	}
	public float getGasUsed() {
		return gasUsed;
	}
	public void setGasUsed(float gasUsed) {
		this.gasUsed = gasUsed;
	}
	public float getGasCharges() {
		return gasCharges;
	}
	public void setGasCharges(float gasCharges) {
		this.gasCharges = gasCharges;
	}
	public float getWaterUsed() {
		return waterUsed;
	}
	public void setWaterUsed(float waterUsed) {
		this.waterUsed = waterUsed;
	}
	public float getWaterCharges() {
		return waterCharges;
	}
	public void setWaterCharges(float waterCharges) {
		this.waterCharges = waterCharges;
	}
	public float getSewerageCharges() {
		return sewerageCharges;
	}
	public void setSewerageCharges(float sewerageCharges) {
		this.sewerageCharges = sewerageCharges;
	}
	public float getRefuseCharges() {
		return refuseCharges;
	}
	public void setRefuseCharges(float refuseCharges) {
		this.refuseCharges = refuseCharges;
	}
}
