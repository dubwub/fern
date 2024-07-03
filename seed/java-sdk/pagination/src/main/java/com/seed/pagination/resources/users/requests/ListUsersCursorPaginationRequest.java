/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.pagination.resources.users.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.pagination.core.ObjectMappers;
import com.seed.pagination.resources.users.types.Order;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ListUsersCursorPaginationRequest.Builder.class)
public final class ListUsersCursorPaginationRequest {
    private final Optional<Integer> page;

    private final Optional<Integer> perPage;

    private final Optional<Order> order;

    private final Optional<String> startingAfter;

    private final Map<String, Object> additionalProperties;

    private ListUsersCursorPaginationRequest(
            Optional<Integer> page,
            Optional<Integer> perPage,
            Optional<Order> order,
            Optional<String> startingAfter,
            Map<String, Object> additionalProperties) {
        this.page = page;
        this.perPage = perPage;
        this.order = order;
        this.startingAfter = startingAfter;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Defaults to first page
     */
    @JsonProperty("page")
    public Optional<Integer> getPage() {
        return page;
    }

    /**
     * @return Defaults to per page
     */
    @JsonProperty("per_page")
    public Optional<Integer> getPerPage() {
        return perPage;
    }

    @JsonProperty("order")
    public Optional<Order> getOrder() {
        return order;
    }

    /**
     * @return The cursor used for pagination in order to fetch
     * the next page of results.
     */
    @JsonProperty("starting_after")
    public Optional<String> getStartingAfter() {
        return startingAfter;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListUsersCursorPaginationRequest && equalTo((ListUsersCursorPaginationRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListUsersCursorPaginationRequest other) {
        return page.equals(other.page)
                && perPage.equals(other.perPage)
                && order.equals(other.order)
                && startingAfter.equals(other.startingAfter);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.page, this.perPage, this.order, this.startingAfter);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Integer> page = Optional.empty();

        private Optional<Integer> perPage = Optional.empty();

        private Optional<Order> order = Optional.empty();

        private Optional<String> startingAfter = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListUsersCursorPaginationRequest other) {
            page(other.getPage());
            perPage(other.getPerPage());
            order(other.getOrder());
            startingAfter(other.getStartingAfter());
            return this;
        }

        @JsonSetter(value = "page", nulls = Nulls.SKIP)
        public Builder page(Optional<Integer> page) {
            this.page = page;
            return this;
        }

        public Builder page(Integer page) {
            this.page = Optional.of(page);
            return this;
        }

        @JsonSetter(value = "per_page", nulls = Nulls.SKIP)
        public Builder perPage(Optional<Integer> perPage) {
            this.perPage = perPage;
            return this;
        }

        public Builder perPage(Integer perPage) {
            this.perPage = Optional.of(perPage);
            return this;
        }

        @JsonSetter(value = "order", nulls = Nulls.SKIP)
        public Builder order(Optional<Order> order) {
            this.order = order;
            return this;
        }

        public Builder order(Order order) {
            this.order = Optional.of(order);
            return this;
        }

        @JsonSetter(value = "starting_after", nulls = Nulls.SKIP)
        public Builder startingAfter(Optional<String> startingAfter) {
            this.startingAfter = startingAfter;
            return this;
        }

        public Builder startingAfter(String startingAfter) {
            this.startingAfter = Optional.of(startingAfter);
            return this;
        }

        public ListUsersCursorPaginationRequest build() {
            return new ListUsersCursorPaginationRequest(page, perPage, order, startingAfter, additionalProperties);
        }
    }
}
