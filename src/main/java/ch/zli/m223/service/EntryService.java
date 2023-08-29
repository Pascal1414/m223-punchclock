package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import ch.zli.m223.model.Entry;

@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    public Entry findEntryById(Long id) {
        return entityManager.find(Entry.class, id);
    }

    @Transactional
    public void deleteEntry(Long id) {
        var entry = findEntryById(id);
        if (entry == null)
            throw new NotFoundException("id not found");
        entityManager.remove(entry);
    }

    @Transactional
    public Entry updateEntry(Long id, Entry entry) {
        entry.setId(id);
        return entityManager.merge(entry);
    }

    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry", Entry.class);
        return query.getResultList();
    }
}
