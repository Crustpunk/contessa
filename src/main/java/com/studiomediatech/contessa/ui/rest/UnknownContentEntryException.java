package com.studiomediatech.contessa.ui.rest;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnknownContentEntryException extends RuntimeException {

    // OK
}
