package pe.com.fravadent.restcontroller.generic;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pe.com.fravadent.dto.base.BaseDTO;
import pe.com.fravadent.service.generic.GenericoService;

public abstract class GenericoRestController<T extends BaseDTO> {

	protected abstract GenericoService<T> getServicio();

	@GetMapping
	public ResponseEntity<List<T>> findAll() {
		return ResponseEntity.ok(getServicio().findAll());
	}

	@GetMapping("/custom")
	public ResponseEntity<List<T>> findAllCustom() {
		return ResponseEntity.ok(getServicio().findAllCustom());
	}

	@GetMapping("/{id}")
	public ResponseEntity<T> findById(@PathVariable Long id) {
		T obj = getServicio().findById(id);
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(obj);
	}

	@PostMapping
	public ResponseEntity<T> add(@RequestBody T obj) {
		return ResponseEntity.ok(getServicio().add(obj));
	}

	@PutMapping("/{id}")
	public ResponseEntity<T> update(@RequestBody T obj, @PathVariable Long id) {
		return ResponseEntity.ok(getServicio().update(obj, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<T> delete(@PathVariable Long id) {
		return ResponseEntity.ok(getServicio().delete(id));
	}

	@PatchMapping("/{id}/enable")
	public ResponseEntity<T> enable(@PathVariable Long id) {
		return ResponseEntity.ok(getServicio().enable(id));
	}
}
