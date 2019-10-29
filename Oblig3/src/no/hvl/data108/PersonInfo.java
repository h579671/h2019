package no.hvl.data108;

public class PersonInfo {
	private String fornavn;
	private String etternavn;
	private String mobilnr;
	private String passord;
	private String passordto;
	private String kjonn;
	
	public PersonInfo() {};
	
	public PersonInfo(String fornavn, String etternavn, String mobilnr, String passord, String passordto, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobilnr = mobilnr;
		this.passord = passord;
		this.passordto = passordto;
		this.kjonn = kjonn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobilnr() {
		return mobilnr;
	}

	public void setMobilnr(String mobilnr) {
		this.mobilnr = mobilnr;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getPassordto() {
		return passordto;
	}

	public void setPassordto(String passordto) {
		this.passordto = passordto;
	}

	public String isKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	
	

}
