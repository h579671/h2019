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
