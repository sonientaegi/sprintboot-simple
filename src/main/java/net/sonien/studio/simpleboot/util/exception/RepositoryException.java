package net.sonien.studio.simpleboot.util.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RepositoryException extends BaseException {
    protected final String repository;

    protected RepositoryException(String repository, int code) {
        super("Repository " + repository + " 접근 중 오류가 발생했습니다.", code);
        this.repository = repository;
    }

    public RepositoryException(String repository) {
        this(repository, 100);
    }
}
