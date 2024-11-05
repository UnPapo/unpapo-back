package com.comparsas.unpapo.utils.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {
    private int page;
    private int size;
    private Long offset;
    private int numberOfElements;
    private int numberOfPages;
    private Long totalNumberOfElements;
    private boolean isFirstPage;
    private boolean isLastPage;
    private boolean hasNextPage;

    public static Pagination from(Page<?> page, Pageable pageable) {
        return Pagination.builder()
                .page(page.getNumber() + 1)
                .size(pageable.getPageSize())
                .offset(page.getPageable().getOffset())
                .numberOfElements(page.getNumberOfElements())
                .totalNumberOfElements(page.getTotalElements())
                .numberOfPages(page.getTotalPages())
                .isFirstPage(page.isFirst())
                .isLastPage(page.isLast())
                .hasNextPage(page.hasNext())
                .build();
    }

}
