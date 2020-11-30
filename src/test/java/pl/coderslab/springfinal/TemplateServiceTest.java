package pl.coderslab.springfinal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.repository.TemplateRepository;
import pl.coderslab.springfinal.service.TemplateService;
import pl.coderslab.springfinal.service.TemplateServiceDb;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class TemplateServiceTest {
    @Mock
    private TemplateRepository mockTemplateRepository;

    private TemplateService templateServiceUnderTest;
    private Template template;

    @Before
    public void setUp() {
        initMocks(this);
        templateServiceUnderTest = new TemplateServiceDb(mockTemplateRepository);

        template = Template.builder()
                .id(1L)
                .name("testTemplate")
                .description("test description")
                .content("test content")
                .createdAt("2020-10-10 20:00:00")
                .build();


        Mockito.when(mockTemplateRepository.save(any())).thenReturn(template);
        Mockito.when(mockTemplateRepository.findByName(anyString())).thenReturn(template);
        Mockito.when(mockTemplateRepository.getOne(anyLong())).thenReturn(template);
    }

    @Test
    public void testFindTemplateByName() {
        // Setup
        final String name = "testTemplate";

        // Run the test
        final Template result = templateServiceUnderTest.findOneByName(name);

        // Verify the results
        assertEquals(name, result.getName());
    }

    @Test
    public void testFindTemplateById() {
        // Setup
        final Long id = 1L;

        // Run the test
        final Template result = templateServiceUnderTest.findOneById(id);

        // Verify the results
        assertEquals(id, result.getId());
    }

    @Test
    public void testSaveTemplate() {
        // Setup
        final String name = "testTemplate";

        // Run the test
        Template result = templateServiceUnderTest.save(Template.builder().build());

        // Verify the results
        assertEquals(name, result.getName());
    }
}
