package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Data
public class Product {
    private @NotNull Integer id;
    private @NotNull String name;
    private @NotNull String companyName;
    private @NotNull Integer count;
}
