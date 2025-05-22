package site.owd.docs;

public record GetApiDto(
    String name,
    int age,
    String email,
    String phone,
    String address
) {
}
