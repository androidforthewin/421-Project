package com.bstrawn;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/** This is the class that all programs extend; there aren't any fields in common */
@PersistenceCapable
public abstract class ProgramOfDistinction {
	
	@PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
	protected long id;

	public ProgramOfDistinction () {

	}

	public long getId()
    {
        return id;
    }
}