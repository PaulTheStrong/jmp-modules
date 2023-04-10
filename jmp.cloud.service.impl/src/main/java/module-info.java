import com.epam.jmp.cloud.service.impl.ServiceImpl;
import com.epam.jmp.service.api.Service;

module jmp.cloud.service.impl {
    requires transitive jmp.service.api;
    requires jmp.dto;
    provides Service with ServiceImpl;

    exports com.epam.jmp.cloud.service.impl;
}