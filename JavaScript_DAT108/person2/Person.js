"use strict";

/**
 * Klasse som definerer en person.
 *
 * @author Atle Geitung
 */
class Person {
    /**
     * Oppretter en ny person.
     *
     * @param fornavn
     * @param etternavn
     * @param postnummer
     * @param telefon
     */
    constructor(fornavn = "", etternavn = "", postnummer = "", telefon = "") {
        this._fornavn = fornavn;
        this._etternavn = etternavn;
        this._postnummer = postnummer;
        this._telefon = telefon;
    }

    /**
     * Set attributes from JSON data.
     *
     * @param json the data
     */
    fromJson(json) {
        let object = JSON.parse (json);
        this.fornavn = object.fornavn;
        this.etternavn = object.etternavn;
        this.postnummer = object.postnummer;
        this.telefon = object.telefon;
    }

    /**
     * Create JSON from attributes.
     *
     * @return json data
     */
    toJson() {
        return ("{" +
            "\"fornavn\":\"" + this.fornavn + "\"," +
            "\"etternavn\":\"" + this.etternavn + "\"," +
            "\"postnummer\":\"" + this.postnummer + "\"," +
            "\"telefon\":" + this.telefon +
            "}");
    }

    get fornavn() {
        return this._fornavn;
    }

    set fornavn(fornavn) {
        this._fornavn = fornavn;
    }

    get etternavn() {
        return this._etternavn;
    }

    set etternavn(etternavn) {
        this._etternavn = etternavn;
    }

    get postnummer() {
        return this._postnummer;
    }

    set postnummer(postnummer) {
        this._postnummer = postnummer;
    }

    get telefon() {
        return this._telefon;
    }

    set telefon(telefon) {
        this._telefon = telefon;
    }
}
