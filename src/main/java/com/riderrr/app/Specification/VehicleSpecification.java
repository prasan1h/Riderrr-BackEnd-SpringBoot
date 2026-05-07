
package com.riderrr.app.Specification;

import com.riderrr.app.Entity.Vehicle;
import com.riderrr.app.Enum.Status;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleSpecification {

    public static Specification<Vehicle> build(
            String search,
            List<String> brands,
            List<String> colors,
            List<long[]> priceRanges,
            List<int[]> yearRanges
    ) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();


            predicates.add(cb.equal(root.get("status"), Status.ACCEPTED));
            predicates.add(cb.equal(root.get("availability"), "AVAILABLE"));
            predicates.add(cb.equal(root.get("isVisible"), true));

            // Search by model or brand
            if (search != null && !search.isBlank()) {
                String like = "%" + search.toLowerCase() + "%";
                predicates.add(cb.or(
                        cb.like(cb.lower(root.get("model")), like),
                        cb.like(cb.lower(root.get("brand")), like)
                ));
            }

            // Brand filter
            if (brands != null && !brands.isEmpty()) {
                List<String> lowerBrands = brands.stream()
                        .map(String::toLowerCase).toList();
                predicates.add(cb.lower(root.get("brand")).in(lowerBrands));  // ✅
            }

            // Color filter
            if (colors != null && !colors.isEmpty()) {
                List<String> lowerColors = colors.stream()
                        .map(String::toLowerCase).toList();
                predicates.add(cb.lower(root.get("colour")).in(lowerColors));  // ✅
            }

            // Price range filter
            if (priceRanges != null && !priceRanges.isEmpty()) {
                List<Predicate> pricePredicates = new ArrayList<>();
                for (long[] range : priceRanges) {
                    pricePredicates.add(cb.between(
                            root.get("outLetPrice"),   // ✅
                            (double) range[0],
                            (double) range[1]
                    ));
                }
                predicates.add(cb.or(pricePredicates.toArray(new Predicate[0])));
            }

            // Year range filter
            if (yearRanges != null && !yearRanges.isEmpty()) {
                List<Predicate> yearPredicates = new ArrayList<>();
                for (int[] range : yearRanges) {
                    yearPredicates.add(cb.between(
                            root.get("modelYear"),    // ✅
                            range[0],
                            range[1]
                    ));
                }
                predicates.add(cb.or(yearPredicates.toArray(new Predicate[0])));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}