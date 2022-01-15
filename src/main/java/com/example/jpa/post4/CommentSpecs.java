package com.example.jpa.post4;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CommentSpecs {

    public static Specification<Comment4> isBest() {
        return (Specification<Comment4>) (root, query, builder) -> builder.isTrue(root.get(Comment4_.best));
    }

    public static Specification<Comment4> isGood() {
        return new Specification<Comment4>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Comment4> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.greaterThanOrEqualTo(root.get(Comment4_.up), 10);
            }
        };
    }
}
