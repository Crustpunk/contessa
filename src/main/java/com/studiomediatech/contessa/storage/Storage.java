package com.studiomediatech.contessa.storage;

import com.studiomediatech.contessa.domain.Entry;
import com.studiomediatech.contessa.logging.Loggable;

import java.util.Optional;


/**
 * Declares the API for storing and retrieving content data assets.
 */
public interface Storage extends Loggable {

    void store(Entry entry);


    Optional<Entry> retrieve(String identifier);
}
